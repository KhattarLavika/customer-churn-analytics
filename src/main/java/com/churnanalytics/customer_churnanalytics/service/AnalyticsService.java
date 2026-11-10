
package com.churnanalytics.customer_churnanalytics.service;

import com.churnanalytics.customer_churnanalytics.dto.DatasetOverviewResponse;
import com.churnanalytics.customer_churnanalytics.repository.AnalyticsRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public DatasetOverviewResponse getDatasetOverview() {
        return analyticsRepository.getDatasetOverview();
    }
}
