package com.pojo.response.ScenarioApi.AddScenario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddScenarioResponseDTO {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("softwareSpecialist")
    @Expose
    private String softwareSpecialist;
    @SerializedName("testSpecialist")
    @Expose
    private String testSpecialist;
    @SerializedName("manualEffort")
    @Expose
    private Integer manualEffort;
    @SerializedName("serviceEndpoint")
    @Expose
    private String serviceEndpoint;
    @SerializedName("repoAddress")
    @Expose
    private String repoAddress;
    @SerializedName("bankInOut")
    @Expose
    private Boolean bankInOut;
    @SerializedName("environment")
    @Expose
    private String environment;
    @SerializedName("testLevel")
    @Expose
    private String testLevel;
    @SerializedName("module")
    @Expose
    private Module module;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSoftwareSpecialist() {
        return softwareSpecialist;
    }

    public void setSoftwareSpecialist(String softwareSpecialist) {
        this.softwareSpecialist = softwareSpecialist;
    }

    public String getTestSpecialist() {
        return testSpecialist;
    }

    public void setTestSpecialist(String testSpecialist) {
        this.testSpecialist = testSpecialist;
    }

    public Integer getManualEffort() {
        return manualEffort;
    }

    public void setManualEffort(Integer manualEffort) {
        this.manualEffort = manualEffort;
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    public String getRepoAddress() {
        return repoAddress;
    }

    public void setRepoAddress(String repoAddress) {
        this.repoAddress = repoAddress;
    }

    public Boolean getBankInOut() {
        return bankInOut;
    }

    public void setBankInOut(Boolean bankInOut) {
        this.bankInOut = bankInOut;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getTestLevel() {
        return testLevel;
    }

    public void setTestLevel(String testLevel) {
        this.testLevel = testLevel;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
