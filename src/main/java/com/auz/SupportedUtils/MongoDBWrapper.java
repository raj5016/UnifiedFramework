package com.auz.SupportedUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBWrapper {
	public static MongoClient mongoConn = null;
	public static MongoDatabase database = null;
	public static MongoCollection<Document> collection = null;
	public static FindIterable<Document> docs = null;

	public static MongoClient createConnection() {
		try {
			mongoConn = createMongoDBConnection(lib.configData.getProperty("MongoDatabaseServer"),
					lib.configData.getProperty("MongoDatabasePort"));
		} catch (Exception e) {
			System.out.println("Exception occured while connecting Database: " + e.getMessage());
			e.printStackTrace();
		}
		return mongoConn;
	}

	public static MongoClient createMongoDBConnection(String sServer, String portNumber) throws Exception {
		try {
			mongoConn = new MongoClient(sServer, Integer.parseInt(portNumber));
			System.out.println("Connected..!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mongoConn;
	}

	public static MongoCollection<Document> getCollection(String collectionName) {
		try {
			mongoConn = createConnection();
			database = mongoConn.getDatabase(lib.configData.getProperty("MongoDatabaseName"));
			collection = database.getCollection(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collection;
	}

	public static void dropCollection(String collectionName) {
		try {
			collection = getCollection(collectionName);
			if (collection != null) {
				collection.drop();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createCollection(String collectionName) {
		try {
			collection = getCollection(collectionName);
			if (collection !=null) {
				dropCollection(collectionName);
			}database.createCollection(collectionName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void InsertOneDocument(String collectionName, String jsonString) throws Exception {
		try {
			collection = getCollection(collectionName);
			Document doc = Document.parse(jsonString);
			System.out.println("This is new collection..!");
			collection.insertOne(doc);
			System.out.println("Document inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while inserting  Document");

		}
	}

	public static void InsertMultiDocuments(String collectionName, ArrayList<String> jsonList) throws Exception {
		ArrayList<Document> documentList = new ArrayList<Document>();
		try {
			collection = getCollection(collectionName);
			for (String document : jsonList) {
				Document doc = Document.parse(document);
				documentList.add(doc);
			}
			collection.insertMany(documentList);
			System.out.println("Mult Document inserted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while inserting multi Document");
		}
	}

	public static List<HashMap> getRecords(String collectionName, String query) {
		List<HashMap> resultList = new ArrayList();
		try {
			ArrayList<Document> documentList = new ArrayList<Document>();
			collection = getCollection(collectionName);
			//System.out.println("Retrived collection is :" + collection.getNamespace());
			BasicDBObject whereQuery = BasicDBObject.parse(query);
			System.out.println("whereQuery :" + whereQuery);
			docs = collection.find(whereQuery);
			for (Document doc : docs) {
				HashMap row = new HashMap();
				for (String property : doc.keySet()) {
					row.put(property, doc.get(property));
				}
				resultList.add(row);
				System.out.println("resultList : " +resultList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public static void closeMongoDbconnection() {
		try {
			if (mongoConn != null) {
				mongoConn.close();
			}
		} catch (Exception ex) {
			System.out.println("Exception Occured while closing the Mongo Connection " + ex.getMessage());
		}

	}
}
