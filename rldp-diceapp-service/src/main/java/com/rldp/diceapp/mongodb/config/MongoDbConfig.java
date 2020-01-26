package com.rldp.diceapp.mongodb.config;

import java.util.Arrays;

import javax.annotation.PreDestroy;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rldp.diceapp.mongodb.util.MongoSSLCertificateUtility;

@Component
@PropertySource(value = { "classpath:mongodb-config/default.properties",
		"classpath:mongodb-config/${spring.profiles.active}.properties" }, ignoreResourceNotFound = true)
public class MongoDbConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDbConfig.class);

	@Value("${com.rldp.mongodb.dbuser}")
	private String dbUser;

	@Value("${com.rldp.mongodb.dbpwd}")
	private String dbPwd;

	@Value("${com.rldp.mongodb.dbname}")
	private String dbName;

	@Value("${com.rldp.mongodb.dbAddress}")
	private String dbAddress;

	@Value("${com.rldp.mongodb.database.sslenabled}")
	private Boolean sslEnabled;

	@Value("${com.rldp.mongodb.database.invalidhostnameallowed}")
	private Boolean invalidHostNameAllowed;

	@Value("${com.rldp.mongodb.database.maxConnectionIdleTime}")
	private int maxConnectionIdleTime;

	@Value("${com.rldp.mongodb.database.minConnectionsPerHost}")
	private int minConnectionsPerHost;

	@Value("${com.rldp.mongodb.database.connectionsPerHost}")
	private int connectionsPerHost;

	private MongoClient mongoClient;

	private MongoDatabase database;

	public MongoDatabase getDatabase() {
		return this.database;
	}

	@Bean
	@ConditionalOnProperty(value = "com.rldp.mongodb.local", havingValue = "true", matchIfMissing = true)
	public MongoClient localMongoDbClient() {
		mongoClient = new MongoClient();
		this.database = mongoClient.getDatabase(this.dbName);
		return mongoClient;
	}

	@Bean
	@ConditionalOnProperty(value = "com.rldp.mongodb.local", havingValue = "true", matchIfMissing = true)
	public MongoDbFactory localMongoDbFactory() {
		return new SimpleMongoDbFactory(localMongoDbClient(), this.dbName);
	}

	@Bean
	@ConditionalOnProperty(value = "com.rldp.mongodb.local", havingValue = "false", matchIfMissing = false)
	public MongoClient mongoDbClient() {

		LOGGER.info("Initializing mongodb connection");
		try {
			char[] pwd = this.dbPwd.toCharArray();
			MongoCredential credential = MongoCredential.createCredential(this.dbUser, this.dbName, pwd);

			MongoClientOptions.Builder options = new MongoClientOptions.Builder().sslEnabled(sslEnabled)
					.sslInvalidHostNameAllowed(invalidHostNameAllowed).maxConnectionIdleTime(maxConnectionIdleTime)
					.minConnectionsPerHost(minConnectionsPerHost).connectionsPerHost(connectionsPerHost)
					.socketFactory(MongoSSLCertificateUtility.mongoDbSocketFactory());

			mongoClient = new MongoClient(Arrays.asList(new ServerAddress(this.dbAddress)), credential,
					options.build());
			this.database = mongoClient.getDatabase(this.dbName);
			LOGGER.info("Mongodb connection initialized");
		} catch (Exception e) {
			LOGGER.error("Exception while creating mongodb connection", e);
		}
		return mongoClient;
	}

	@Bean
	@ConditionalOnProperty(value = "com.rldp.mongodb.local", havingValue = "false", matchIfMissing = false)
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(mongoDbClient(), this.dbName);
	}

	@PreDestroy
	public void preDestroy() {
		if (this.mongoClient != null) {
			this.mongoClient.close();
		}
	}

	public MongoCollection<Document> getCollection(String collection) {
		return this.getDatabase().getCollection(collection);
	}
}
