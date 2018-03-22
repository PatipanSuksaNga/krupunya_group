package process;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
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

import data.*;

public class DatabaseHandler {
	public static void main(String args[]) {
		PushData();
	}

	public static void PushData() {

		Mongo mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "krupunya", "password".toCharArray());
		System.out.println("Connected to the database successfully");
		DB database = mongo.getDB("krupunya");
		System.out.println("Credentials ::" + credential);

		/*DBCollection collection = database.getCollection("mycollec");
		collection.remove(new BasicDBObject());

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
		}*/
		
		
		
		
		
		
		DBCollection buybill_collection = database.getCollection("buybill");
		buybill_collection.remove(new BasicDBObject());
		
		for(Buybill b : BillCollections.buybill) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id",b.id );
			bill.put("name",b.name );
			bill.put("address",b.address );
			bill.put("phone",b.phone_number );
			bill.put("taker",b.taker );
			bill.put("whighter",b.weighter );
			bill.put("issue_date",b.issue_date );
			bill.put("paid_date",b.paid_date );
			bill.put("product_type",b.product_type );
			bill.put("status",b.status );
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for(Product p : b.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number",p.secret_number );
				product.put("size",p.size);
				product.put("weight",p.weight);
				product.put("price",p.price);
				productList.add(product);
			}
			bill.put("products",productList );
			buybill_collection.insert(bill);
		}
		
		DBCollection sellbill_collection = database.getCollection("sellbill");
		sellbill_collection.remove(new BasicDBObject());
		
		for(Sellbill s : BillCollections.sellbill) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id",s.id );
			bill.put("name",s.name );
			bill.put("address",s.address );
			bill.put("phone",s.phone_number );
			bill.put("issue_date",s.issue_date );
			bill.put("paid_date",s.paid_date );
			bill.put("product_type",s.product_type );
			bill.put("status",s.status );
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for(Product p : s.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number",p.secret_number );
				product.put("size",p.size);
				product.put("weight",p.weight);
				product.put("price",p.price);
				productList.add(product);
			}
			bill.put("products",productList );
			sellbill_collection.insert(bill);
		}
		
		DBCollection expenditure_collection = database.getCollection("expenditure");
		expenditure_collection.remove(new BasicDBObject());
		
		for(Expenditure e : External.expenditure) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id",e.id );
			bill.put("list", e.list);
			bill.put("amount", e.amount);
			bill.put("issue_date", e.issue_date);
			expenditure_collection.insert(bill);
		}
		
		DBCollection revenue_collection = database.getCollection("revenue");
		revenue_collection.remove(new BasicDBObject());
		
		for(Revenue r : External.revenue) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id",r.id );
			bill.put("list", r.list);
			bill.put("amount", r.amount);
			bill.put("issue_date", r.issue_date);
			revenue_collection.insert(bill);
		}
		
		DBCursor cursorDoc1 = buybill_collection.find();
		while (cursorDoc1.hasNext()) {
			System.out.println(cursorDoc1.next());
		}
		DBCursor cursorDoc2 = sellbill_collection.find();
		while (cursorDoc2.hasNext()) {
			System.out.println(cursorDoc2.next());
		}
		DBCursor cursorDoc3 = expenditure_collection.find();
		while (cursorDoc3.hasNext()) {
			System.out.println(cursorDoc3.next());
		}
		DBCursor cursorDoc4 = revenue_collection.find();
		while (cursorDoc4.hasNext()) {
			System.out.println(cursorDoc4.next());
		}
		
		

	}
}
