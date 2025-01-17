package com.pojo.response.ScenarioApi.AddScenario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("moduleManager")
    @Expose
    private String moduleManager;

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

    public String getModuleManager() {
        return moduleManager;
    }

    public void setModuleManager(String moduleManager) {
        this.moduleManager = moduleManager;
    }

}
