package com.churnanalytics.customer_churnanalytics.repository;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.churnanalytics.customer_churnanalytics.entity.Customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Maps a database row to a Customer object
    private final RowMapper<Customer> customerRowMapper = (rs, rowNum) -> {

        Customer customer = new Customer();

        customer.setId(rs.getLong("id"));
        customer.setCustomerId(rs.getString("customer_id"));
        customer.setGender(rs.getString("gender"));
        customer.setSeniorCitizen(rs.getBoolean("senior_citizen"));
        customer.setPartner(rs.getBoolean("partner"));
        customer.setDependents(rs.getBoolean("dependents"));
        customer.setTenure(rs.getInt("tenure"));

        customer.setPhoneService(rs.getBoolean("phone_service"));
        customer.setMultipleLines(rs.getString("multiple_lines"));
        customer.setInternetService(rs.getString("internet_service"));
        customer.setOnlineSecurity(rs.getString("online_security"));
        customer.setOnlineBackup(rs.getString("online_backup"));
        customer.setDeviceProtection(rs.getString("device_protection"));
        customer.setTechSupport(rs.getString("tech_support"));
        customer.setStreamingTV(rs.getString("streaming_tv"));
        customer.setStreamingMovies(rs.getString("streaming_movies"));

        customer.setContract(rs.getString("contract"));
        customer.setPaperlessBilling(rs.getBoolean("paperless_billing"));
        customer.setPaymentMethod(rs.getString("payment_method"));

        customer.setMonthlyCharges(rs.getBigDecimal("monthly_charges"));
        customer.setTotalCharges(rs.getBigDecimal("total_charges"));
        customer.setChurn(rs.getBoolean("churn"));

        return customer;
    };

    // CREATE: Insert a customer

    public Customer save(Customer customer) {

        String sql = """
            INSERT INTO customer (
                customer_id, gender, senior_citizen, partner,
                dependents, tenure, phone_service, multiple_lines,
                internet_service, online_security, online_backup,
                device_protection, tech_support, streaming_tv,
                streaming_movies, contract, paperless_billing,
                payment_method, monthly_charges, total_charges, churn
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, customer.getCustomerId());
            ps.setString(2, customer.getGender());
            ps.setBoolean(3, customer.isSeniorCitizen());
            ps.setBoolean(4, customer.isPartner());
            ps.setBoolean(5, customer.isDependents());
            ps.setObject(6, customer.getTenure());
            ps.setBoolean(7, customer.isPhoneService());
            ps.setString(8, customer.getMultipleLines());
            ps.setString(9, customer.getInternetService());
            ps.setString(10, customer.getOnlineSecurity());
            ps.setString(11, customer.getOnlineBackup());
            ps.setString(12, customer.getDeviceProtection());
            ps.setString(13, customer.getTechSupport());
            ps.setString(14, customer.getStreamingTV());
            ps.setString(15, customer.getStreamingMovies());
            ps.setString(16, customer.getContract());
            ps.setBoolean(17, customer.isPaperlessBilling());
            ps.setString(18, customer.getPaymentMethod());
            ps.setBigDecimal(19, customer.getMonthlyCharges());
            ps.setBigDecimal(20, customer.getTotalCharges());
            ps.setBoolean(21, customer.isChurn());

            return ps;

        }, keyHolder);

        Number generatedId = (Number) keyHolder.getKeys().get("id");

        if (generatedId != null) {
            customer.setId(generatedId.longValue());
        }

        return customer;
    }

    // READ: Retrieve all customers
    public List<Customer> findAll() {

        String sql = "SELECT * FROM customer";

        return jdbcTemplate.query(sql, customerRowMapper);
    }

    // READ: Retrieve customer by database ID
    public Optional<Customer> findById(Long id) {

        String sql = "SELECT * FROM customer WHERE id = ?";

        List<Customer> customers = jdbcTemplate.query(
                sql, customerRowMapper, id
        );

        return customers.stream().findFirst();
    }

    // UPDATE: Update an existing customer
    public int updateMonthlyCharges(Long id, BigDecimal monthlyCharges) {

        String sql = """
                UPDATE customer 
                SET monthly_charges=?
                WHERE id=?
                """;

        return jdbcTemplate.update(sql, monthlyCharges, id);
    }

    // DELETE: Delete a customer
    public int deleteById(Long id) {

        String sql = "DELETE FROM customer WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}
