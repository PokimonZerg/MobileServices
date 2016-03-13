package com.acumatica.services.configuration;

import com.acumatica.services.configuration.model.Key;
import com.acumatica.services.configuration.model.KeyList;
import com.acumatica.services.configuration.model.ServiceList;
import com.mongodb.client.model.UpdateOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.naming.InitialContext;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.collections4.IteratorUtils;
import org.bson.Document;

@Path("")
public class ConfigurationServiceImpl implements ConfigurationService{

    @javax.ws.rs.core.Context
    UriInfo uri;
            
    @Override
    public ServiceList listServices() {
        return new ServiceList(IteratorUtils.toList(MongoConnector.get().listCollectionNames().iterator()));
    }

    @Override
    public KeyList listKeys(String service) {
        List<Key> keys = new ArrayList<>();
        
        for (Document doc : MongoConnector.get().getCollection(service).find()) {
            for (Entry<String, Object> key : doc.entrySet()) {
                if (key.getKey().equals("_id")) 
                    continue;
                
                keys.add(new Key(key.getKey(), (String)key.getValue()));
            }
        }
        
        return new KeyList(keys);
    }

    @Override
    public Response addService(String service) {
        MongoConnector.get().createCollection(service);
        
        return Response.ok().build();
    }

    @Override
    public Response deleteService(String service) {
        MongoConnector.get().getCollection(service).drop();
        
        return Response.ok().build();
    }

    @Override
    public Key getKey(String service, String key) throws WebApplicationException {
        
        try {
           // Hashtable env = new Hashtable();
//env.put(Context.INITIAL_CONTEXT_FACTORY,  
  //  "com.sun.enterprise.naming.SerialInitContextFactory");
            InitialContext ictx = new InitialContext();
        Object c = ictx.lookup("test");
        String cc = c.toString();
        //Object gg = ictx.list("java:comp/env");//.lookup("test");
       // c.bind("hello", "omg");
//        String s  = gg.toString();
       // String ss = c.toString();
        //String s= uri.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
            //String s = e.toString();
        }
        
        
        
        Object value = MongoConnector
                .get()
                .getCollection(service)
                .find(new Document(key, new Document("$exists", true))).first().get(key);
        
        return new Key(key, (String)value);
    }

    @Override
    public Response setKey(String service, String key, String value) {
        MongoConnector
                .get()
                .getCollection(service)
                .updateOne(
                        new Document(key, new Document("$exists", true)),
                        new Document("$set", new Document(key, value)),
                        new UpdateOptions().upsert(true));
        
        return Response.ok().build();
    }

    @Override
    public Response deleteKey(String service, String key) {
        MongoConnector
                .get()
                .getCollection(service)
                .deleteOne(new Document(key, new Document("$exists", true)));
        
        return Response.ok().build();
    }
}
