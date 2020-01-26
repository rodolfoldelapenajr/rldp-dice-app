package com.rldp.diceapp.mongodb.repository;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.WriteResult;
import com.rldp.diceapp.mongodb.config.MorphiaComponent;

/**
 * T -> class type or class entity used in Morphia
 * <p>
 * D -> data type of unique key in DB
 *
 * @param <T>
 * @param <D>
 */
public class CommonRepository<T, D> {

	private final Class<T> typeClass;
	private final String keyColumn;
	
	@Autowired
	protected MorphiaComponent morphia;

	protected CommonRepository(Class<T> typeClass, String keyColumn) {
		this.typeClass = typeClass;
		this.keyColumn = keyColumn;
	}

	public List<T> getAll() {
		return morphia.getDatastore().createQuery(typeClass).asList();
	}

	public List<T> getAll(FindOptions options) {
		return morphia.getDatastore().createQuery(typeClass).asList(options);
	}

	/**
	 * Basic get based on Key Column
	 *
	 * @param criteria
	 * @return
	 */
	public T get(D criteria) {
		return morphia.getDatastore().createQuery(typeClass).field(keyColumn).equal(criteria).get();
	}

	public Query<T> createQuery() {
		return morphia.getDatastore().createQuery(typeClass);
	}

	public UpdateOperations<T> createUpdateOperations() {
		return morphia.getDatastore().createUpdateOperations(typeClass);
	}

	public boolean update(Query<T> query, UpdateOperations<T> operations) {
		UpdateResults updateResult = morphia.getDatastore().update(query, operations);
		return updateResult.getWriteResult().wasAcknowledged();
	}

	public T save(T object) {
		final Datastore datastore = morphia.getDatastore();
		datastore.save(object);
		return object;
	}

	public String remove(D keyValue) {
		final Datastore datastore = morphia.getDatastore();
		final Query<T> query = datastore.createQuery(typeClass).field(keyColumn).equal(keyValue);

		WriteResult delete = datastore.delete(query);

		LoggerFactory.getLogger(typeClass).info("Delete Result: {}", delete);

		return delete.getN() > 0 ? keyValue.toString() : "";
	}
}
