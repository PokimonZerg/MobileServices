package com.acumatica.services.configuration.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "keys")
public class KeyList {
    
    public KeyList() {
        
    }
    
    public KeyList(List<Key> items) {
        this.items = items;
    }
    
    @XmlElement(name = "key")
    public List<Key> items;
}
