package process;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class DatabaseHandler {
	public static void main(String args[]) {
		LoadData();
	}

	public static void LoadData() {

		// Creating a Mongo client
		Mongo mongo = new MongoClient("localhost", 27017);

		// Creating Credentials
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "krupunya", "password".toCharArray());
		System.out.println("Connected to the database successfully");

		// Accessing the database
		DB database = mongo.getDB("krupunya");
		System.out.println("Credentials ::" + credential);

		// Retrieving a collection
		/*
		 * DBCollection collection = (DBCollection)
		 * database.getCollection("sampleCollection");
		 * System.out.println("Collection sampleCollection selected successfully");
		 */

		DBCollection collection = database.getCollection("dummyColl");

		// 1. BasicDBObject example
		System.out.println("BasicDBObject example...");
		BasicDBObject document = new BasicDBObject();
		document.put("database", "mkyongDB");
		document.put("table", "hosting");

		BasicDBObject documentDetail = new BasicDBObject();
		documentDetail.put("records", 99);
		documentDetail.put("index", "vps_index1");
		documentDetail.put("active", "true");
		document.put("detail", documentDetail);

		collection.insert(document);

		DBCursor cursorDoc = collection.find();
		while (cursorDoc.hasNext()) {
			System.out.println(cursorDoc.next());
		}

		collection.remove(new BasicDBObject());

	}
}
