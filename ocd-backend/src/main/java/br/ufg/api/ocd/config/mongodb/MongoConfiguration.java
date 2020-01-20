package br.ufg.api.ocd.config.mongodb;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class MongoConfiguration {

    private String mongoUri = "mongodb://localhost/ocd-DB";

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
        optionsBuilder.socketKeepAlive(true);
        return new SimpleMongoDbFactory(new MongoClientURI(mongoUri, optionsBuilder));
    }
}
