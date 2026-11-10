
package com.churnanalytics.customer_churnanalytics.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CustomerRequest {

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    private String gender = "Unknown";
    private boolean seniorCitizen = false;
    private boolean partner = false;
    private boolean dependents = false;

    @Min(value = 0, message = "Tenure cannot be negative")
    private Integer tenure = 0;
    private boolean phoneService = false;

    private String multipleLines = "No phone service";
    private String internetService = "No";

    private String onlineSecurity = "No internet service";
    private String onlineBackup = "No internet service";
    private String deviceProtection = "No internet service";
    private String techSupport = "No internet service";
    private String streamingTV = "No internet service";
    private String streamingMovies = "No internet service";

    private String contract = "Month-to-month";
    private boolean paperlessBilling = false;
    private String paymentMethod = "Unknown";

    @NotNull(message = "Monthly charges are required")
    @DecimalMin(value = "0.0", message = "Monthly charges cannot be negative")
    private BigDecimal monthlyCharges;

    @DecimalMin(value = "0.0", message = "Total charges cannot be negative")
    private BigDecimal totalCharges;
    private boolean churn = false;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSeniorCitizen() {
        return seniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        this.seniorCitizen = seniorCitizen;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public boolean isDependents() {
        return dependents;
    }

    public void setDependents(boolean dependents) {
        this.dependents = dependents;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public boolean isPhoneService() {
        return phoneService;
    }

    public void setPhoneService(boolean phoneService) {
        this.phoneService = phoneService;
    }

    public String getMultipleLines() {
        return multipleLines;
    }

    public void setMultipleLines(String multipleLines) {
        this.multipleLines = multipleLines;
    }

    public String getInternetService() {
        return internetService;
    }

    public void setInternetService(String internetService) {
        this.internetService = internetService;
    }

    public String getOnlineSecurity() {
        return onlineSecurity;
    }

    public void setOnlineSecurity(String onlineSecurity) {
        this.onlineSecurity = onlineSecurity;
    }

    public String getOnlineBackup() {
        return onlineBackup;
    }

    public void setOnlineBackup(String onlineBackup) {
        this.onlineBackup = onlineBackup;
    }

    public String getDeviceProtection() {
        return deviceProtection;
    }

    public void setDeviceProtection(String deviceProtection) {
        this.deviceProtection = deviceProtection;
    }

    public String getTechSupport() {
        return techSupport;
    }

    public void setTechSupport(String techSupport) {
        this.techSupport = techSupport;
    }

    public String getStreamingTV() {
        return streamingTV;
    }

    public void setStreamingTV(String streamingTV) {
        this.streamingTV = streamingTV;
    }

    public String getStreamingMovies() {
        return streamingMovies;
    }

    public void setStreamingMovies(String streamingMovies) {
        this.streamingMovies = streamingMovies;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public boolean isPaperlessBilling() {
        return paperlessBilling;
    }

    public void setPaperlessBilling(boolean paperlessBilling) {
        this.paperlessBilling = paperlessBilling;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getMonthlyCharges() {
        return monthlyCharges;
    }

    public void setMonthlyCharges(BigDecimal monthlyCharges) {
        this.monthlyCharges = monthlyCharges;
    }

    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    public boolean isChurn() {
        return churn;
    }

    public void setChurn(boolean churn) {
        this.churn = churn;
    }
}
