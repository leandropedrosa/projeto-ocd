package br.ufg.api.ocd.config.mongodb;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMongoRepositories(basePackages = {"br.ufg.api.ocd.repository"})
@ComponentScan(basePackages = {"br.ufg.api.ocd.*"})
@PropertySource("classpath:application.properties")
public class MongoJPAConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private String port;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;

    private MongoClient mongoClient;

//    private static final String MONGO_HOST = "127.0.0.1";
//    private static final String MONGO_DB_NAME = "ocd";
//    private static final String MONGO_PORT = "27017";
//    private static final String MONGO_USER_NAME = "admin";
//    private static final String MONGO_PASSWORD = "123";


    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        try {

            //getMongoClient();
            getMongoClientURI();

        } catch (MongoException e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }

        return mongoClient;
    }

    private void getMongoClient() {
        MongoCredential credential = MongoCredential.createMongoCRCredential(username, database, password.toCharArray());
        mongoClient = new MongoClient(new ServerAddress(host, Integer.parseInt(port)), Arrays.asList(credential));
        mostraStatusConecao();
    }

    private void getMongoClientURI() {
        String MONGO_URI = "mongodb://" + username + ":" + password + "@" + host + ":" + port + "/" + database;
        //String MONGO_URI = "mongodb://"+host + ":" + port + "/" + database;
        mongoClient = new MongoClient(new MongoClientURI(MONGO_URI));
        mostraStatusConecao();

    }

    private void mostraStatusConecao() {

        MongoDatabase db = mongoClient.getDatabase(database);
       // db.runCommand(new Document("ping", 1));

        System.out.println("connecting to host....." + mongoClient);
        System.out.println("connecting to database....." + database);
        System.out.println("connecting to host....." + host);
        System.out.println("connecting to port....." + port);
        System.out.println("connecting to username....." + username);
    }


}
