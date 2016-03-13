package com.acumatica.web.configuration;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConfigurationBean implements Serializable {
    
    private final List<String> services = new ArrayList<>();
    
    public ConfigurationBean() {
        services.add("One");
        services.add("Two");
    }

    public List<String> getServices() {
        return services;
    }
    
    public String getParam() {
        Map<String,String> params;
        params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	  String action = params.get("service");
        return action;
    }
    
    public List<Pair<String, String>> getValues() {
        
        List<Pair<String, String>> data = new ArrayList<>();
        
        data.add(new Pair<>("key1", "value1"));
        data.add(new Pair<>("key2", "value2"));
        
        return data;
    }
}
