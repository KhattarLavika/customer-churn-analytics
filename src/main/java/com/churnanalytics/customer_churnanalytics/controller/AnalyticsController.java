
package com.churnanalytics.customer_churnanalytics.controller;

import com.churnanalytics.customer_churnanalytics.dto.DatasetOverviewResponse;
import com.churnanalytics.customer_churnanalytics.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/summary")
    public ResponseEntity<DatasetOverviewResponse> getDatasetOverview() {

        DatasetOverviewResponse overview =
                analyticsService.getDatasetOverview();

        return ResponseEntity.ok(overview);
    }
}
