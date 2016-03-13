package com.acumatica.services.build;

import com.acumatica.services.build.model.BuildInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/")
public interface BuildService {
    
    @GET
    @Path("/android/{version}")
    public BuildInfo getAndroidBuild(@PathParam("version") String version);
    
    @GET
    @Path("/ios/{version}")
    public BuildInfo getiOSBuild(@PathParam("version") String version);
    
    @GET
    @Path("/download/{version}")
    public Response downloadBuild(@PathParam("version") String version);
}
