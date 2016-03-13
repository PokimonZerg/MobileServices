package com.acumatica.services.configuration.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "key")
public class Key {
    
    public Key() {
        
    }
    
    public Key(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    @XmlElement
    public String name;
    @XmlElement
    public String value;
}
