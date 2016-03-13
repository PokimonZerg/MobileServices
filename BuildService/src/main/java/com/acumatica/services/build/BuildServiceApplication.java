package com.acumatica.services.build;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/builds")
public class BuildServiceApplication extends Application {
    
    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>()
        {{
            add(Object.class);
        }};
    }
}
