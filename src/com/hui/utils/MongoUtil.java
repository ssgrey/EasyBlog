package com.hui.utils;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class MongoUtil {
	
    private static MongoDatabase db;

    public static MongoDatabase getMongoDB() {

        if (db == null) {
            Properties properties = new Properties();
            String host = "";
            int port = 0;
            String username = "";
            String password = "";
            String dbname = "";

                try {
                    properties.load(MongoUtil.class.getClassLoader().getResourceAsStream("properties/mongodb.properties"));
                    host = properties.getProperty("host");
                    port = Integer.parseInt(properties.getProperty("port"));
                    username = properties.getProperty("username");
                    password = properties.getProperty("password");
                    dbname = properties.getProperty("dbname");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            MongoCredential credential = MongoCredential.createCredential(username, dbname, password.toCharArray());
            ServerAddress address = new ServerAddress(host, port);
           // MongoClient mongoClient = new MongoClient(address, Collections.singletonList(credential));
            //System.out.println(host);
           // System.out.println(port);
            MongoClient mongoClient = new MongoClient(host,port);
            db = mongoClient.getDatabase(dbname);
        }
        return db;
    }
}