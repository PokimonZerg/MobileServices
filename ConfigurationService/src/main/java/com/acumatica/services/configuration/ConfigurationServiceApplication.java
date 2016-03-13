package com.acumatica.services.configuration;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/configuration")
public class ConfigurationServiceApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        
        return new HashSet<Class<?>>()
        {{
            add(ConfigurationService.class);
            add(ConfigurationServiceImpl.class);
        }};
    }
}
