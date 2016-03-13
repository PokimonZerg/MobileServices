package com.acumatica.services.configuration;

import com.acumatica.services.configuration.model.Key;
import com.acumatica.services.configuration.model.KeyList;
import com.acumatica.services.configuration.model.ServiceList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public interface ConfigurationService {
    
    @GET
    @Path("/")
    public ServiceList listServices();
    
    @GET
    @Path("/{service}")
    public KeyList listKeys(@PathParam("service") String service);
    
    @PUT
    @Path("/{service}")
    public Response addService(@PathParam("service") String service);
    
    @DELETE
    @Path("/{service}")
    public Response deleteService(@PathParam("service") String service);
    
    @GET
    @Path("/{service}/{key}")
    public Key getKey(@PathParam("service") String service, @PathParam("key") String key) throws WebApplicationException;
    
    @PUT
    @Path("/{service}/{key}")
    public Response setKey(@PathParam("service") String service, @PathParam("key") String key, @QueryParam("value") String value);
    
    @DELETE
    @Path("/{service}/{key}")
    public Response deleteKey(@PathParam("service") String service, @PathParam("key") String key);
}
 