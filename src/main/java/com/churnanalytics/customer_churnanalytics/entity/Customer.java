
package com.churnanalytics.customer_churnanalytics.entity;

import java.math.BigDecimal;

public class Customer {

    public Customer() {
    }
    public Customer(Long id, String customerId, String gender, boolean seniorCitizen, boolean partner, boolean dependents, Integer tenure, boolean phoneService, String multipleLines, String internetService, String onlineSecurity, String onlineBackup, String deviceProtection, String techSupport, String streamingTV, String streamingMovies, String contract, boolean paperlessBilling, String paymentMethod, BigDecimal monthlyCharges, BigDecimal totalCharges, boolean churn) {
        this.id = id;
        this.customerId = customerId;
        this.gender = gender;
        this.seniorCitizen = seniorCitizen;
        this.partner = partner;
        this.dependents = dependents;
        this.tenure = tenure;
        this.phoneService = phoneService;
        this.multipleLines = multipleLines;
        this.internetService = internetService;
        this.onlineSecurity = onlineSecurity;
        this.onlineBackup = onlineBackup;
        this.deviceProtection = deviceProtection;
        this.techSupport = techSupport;
        this.streamingTV = streamingTV;
        this.streamingMovies = streamingMovies;
        this.contract = contract;
        this.paperlessBilling = paperlessBilling;
        this.paymentMethod = paymentMethod;
        this.monthlyCharges = monthlyCharges;
        this.totalCharges = totalCharges;
        this.churn = churn;
    }

    private Long id;

    private String customerId;
    private String gender;
    private boolean seniorCitizen;
    private boolean partner;
    private boolean dependents;
    private Integer tenure;

    private boolean phoneService;
    private String multipleLines;
    private String internetService;
    private String onlineSecurity;
    private String onlineBackup;
    private String deviceProtection;
    private String techSupport;
    private String streamingTV;
    private String streamingMovies;

    private String contract;
    private boolean paperlessBilling;
    private String paymentMethod;

    private BigDecimal monthlyCharges;
    private BigDecimal totalCharges;
    private boolean churn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
