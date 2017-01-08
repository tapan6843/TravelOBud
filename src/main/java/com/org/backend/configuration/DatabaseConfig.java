package com.org.backend.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Jatan on 1/7/2017.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.org.backend.dao")
public class DatabaseConfig extends AbstractMongoConfiguration{

    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;
   /* @Value("${spring.data.mongodb.username}")
    private String username;*/ /*currently not required*/
    @Value("${spring.data.mongodb.database}")
    private String database;
   /* @Value("${spring.data.mongodb.password}")
    private String password;*/ /*currently not required*/

    /**
     * Return the name of the database to connect to.
     *
     * @return must not be {@literal null}.
     */
    @Override
    protected String getDatabaseName() {
        return database;
    }

    /**
     * Return the {@link Mongo} instance to connect to. Annotate with {@link Bean} in case you want to expose a
     * {@link Mongo} instance to the {@link ApplicationContext}.
     *
     * @return
     * @throws Exception
     */
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(host, port);
    }
}
