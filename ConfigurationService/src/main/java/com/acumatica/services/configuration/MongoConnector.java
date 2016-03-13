package com.acumatica.services.configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.ws.rs.WebApplicationException;

public class MongoConnector {
    
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    
    public static MongoDatabase get() {
        if (database == null) {
            mongoClient = new MongoClient();
            database = mongoClient.getDatabase("configuration");
        }
        
        // verify connection
        try
        {
            mongoClient.getAddress();
        }
        catch (Exception e)
        {
            mongoClient.close();
            mongoClient = null;
            database = null;
            
            throw new WebApplicationException("Connection to mongo db failed.");
        }
        
        return database;
    }
}
