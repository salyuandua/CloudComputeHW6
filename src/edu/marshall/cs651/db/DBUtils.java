package edu.marshall.cs651.db;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DBUtils {
private static MongoClient mClient;
static {
	mClient=MongoClients.create();
}

public static MongoClient getClient() {
	return mClient;
}

public static MongoDatabase getDatabase(String databaseName) {
	return mClient.getDatabase(databaseName);
}

public static MongoCollection<Document> getCollection(String databaseName,String collectionName){
	return getDatabase(databaseName).getCollection(collectionName);
	
}

public static void main(String[] args) {
	MongoClient c=DBUtils.getClient();
}



}
