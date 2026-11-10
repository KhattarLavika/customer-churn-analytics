
package com.churnanalytics.customer_churnanalytics.repository;

import com.churnanalytics.customer_churnanalytics.dto.DatasetOverviewResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnalyticsRepository {

    private final JdbcTemplate jdbcTemplate;

    public AnalyticsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DatasetOverviewResponse getDatasetOverview() {

        String sql = """
                SELECT
                    COUNT(*) AS total_customers,

                    COUNT(*) FILTER (WHERE churn = TRUE)
                        AS churned_customers,

                    COUNT(*) FILTER (WHERE churn = FALSE)
                        AS retained_customers,

                    ROUND(
                        COUNT(*) FILTER (WHERE churn = TRUE) * 100.0
                        / NULLIF(COUNT(*), 0), 2
                    ) AS churn_rate,

                    ROUND(
                        COUNT(*) FILTER (WHERE churn = FALSE) * 100.0
                        / NULLIF(COUNT(*), 0), 2
                    ) AS retention_rate,

                    ROUND(AVG(tenure), 2) AS average_tenure,

                    ROUND(AVG(monthly_charges), 2)
                        AS average_monthly_charges

                FROM customer
                """;

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new DatasetOverviewResponse(
                        rs.getLong("total_customers"),
                        rs.getLong("churned_customers"),
                        rs.getLong("retained_customers"),
                        rs.getBigDecimal("churn_rate"),
                        rs.getBigDecimal("retention_rate"),
                        rs.getBigDecimal("average_tenure"),
                        rs.getBigDecimal("average_monthly_charges")
                )
        );
    }
}
