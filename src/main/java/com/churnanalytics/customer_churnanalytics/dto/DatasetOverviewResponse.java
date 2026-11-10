
package com.churnanalytics.customer_churnanalytics.dto;

import java.math.BigDecimal;



public class DatasetOverviewResponse {

    private long totalCustomers;
    private long churnedCustomers;
    private long retainedCustomers;

    private BigDecimal churnRate;
    private BigDecimal retentionRate;

    private BigDecimal averageTenure;
    private BigDecimal averageMonthlyCharges;

    // Constructor
    public DatasetOverviewResponse(
            long totalCustomers,
            long churnedCustomers,
            long retainedCustomers,
            BigDecimal churnRate,
            BigDecimal retentionRate,
            BigDecimal averageTenure,
            BigDecimal averageMonthlyCharges) {

        this.totalCustomers = totalCustomers;
        this.churnedCustomers = churnedCustomers;
        this.retainedCustomers = retainedCustomers;
        this.churnRate = churnRate;
        this.retentionRate = retentionRate;
        this.averageTenure = averageTenure;
        this.averageMonthlyCharges = averageMonthlyCharges;
    }

    // Getters
    public long getTotalCustomers() {
        return totalCustomers;
    }

    public long getChurnedCustomers() {
        return churnedCustomers;
    }

    public long getRetainedCustomers() {
        return retainedCustomers;
    }

    public BigDecimal getChurnRate() {
        return churnRate;
    }

    public BigDecimal getRetentionRate() {
        return retentionRate;
    }

    public BigDecimal getAverageTenure() {
        return averageTenure;
    }

    public BigDecimal getAverageMonthlyCharges() {
        return averageMonthlyCharges;
    }
}
