package com.acumatica.services.configuration.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "services")
public class ServiceList{
    
    public ServiceList() {
        
    }
    
    public ServiceList(List<String> items) {
        this.items = items;
    }
    
    @XmlElement(name = "service")
    public List<String> items;
}
