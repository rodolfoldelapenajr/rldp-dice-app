package com.rldp.diceapp.mongodb.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Component
public class MorphiaComponent {

	private static final String EMPTY = "";

	private Datastore datastore;

	@Value("${com.rldp.mongodb.dbname}")
	private String dbName;

	@Autowired
	private MongoClient mongoClient;

	@Value("${com.rldp.morphia.packages}")
	private String pagkages = EMPTY;

	@PostConstruct
	public void init() {
		Morphia morphia = new Morphia();
		Arrays.stream(pagkages.split(","))
				.forEach(packageName -> morphia.mapPackage(packageName));
		datastore = morphia.createDatastore(mongoClient, dbName);
		datastore.ensureIndexes();
	}

	public Datastore getDatastore() {
		return datastore;
	}
}
