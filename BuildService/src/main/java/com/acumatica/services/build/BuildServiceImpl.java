package com.acumatica.services.build;

import com.acumatica.services.build.model.BuildInfo;
import javax.ws.rs.core.Response;

public class BuildServiceImpl implements BuildService{

    @Override
    public BuildInfo getAndroidBuild(String version) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BuildInfo getiOSBuild(String version) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response downloadBuild(String version) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
