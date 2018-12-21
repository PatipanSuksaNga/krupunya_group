package process;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public static void PushData() {

		System.out.println("	! ! ! PUSH DATA ! ! !");

		Mongo mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "krupunya", "password".toCharArray());
		System.out.println("Connected to the database successfully");
		DB database = mongo.getDB("krupunya");
		System.out.println("Credentials ::" + credential);

		String APPdate = dateIn.year + dateIn.month + dateIn.day;

		DBCollection buybill_collection = database.getCollection("buybill");
		DBCursor buybills_cursor = buybill_collection.find();
		while (buybills_cursor.hasNext()) {
			BasicDBObject document = new BasicDBObject();
			document = (BasicDBObject) buybills_cursor.next();
			if (document.getString("issue_date").compareTo(APPdate) == 0) // database issue date = today issue date -> remove
				buybill_collection.remove(document);
		}

		for (Buybill b : BillCollections.buybill) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", b.id);
			bill.put("name", b.name);
			bill.put("address", b.address);
			bill.put("phone", b.phone_number);
			bill.put("taker", b.taker);
			bill.put("whighter", b.weighter);
			bill.put("issue_date", b.issue_date);
			bill.put("paid_date", b.paid_date);
			bill.put("product_type", b.product_type);
			bill.put("status", b.status);
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for (Product p : b.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number", p.secret_number);
				product.put("size", p.size);
				product.put("weight", p.weight);
				product.put("price", p.price);
				productList.add(product);
			}
			bill.put("products", productList);
			buybill_collection.insert(bill);
		}
		
		for (Buybill b : BillCollections.pay_pending_buybill) {
			
			DBCursor gry_pending_sellbills_cursor = buybill_collection.find();
			while (gry_pending_sellbills_cursor.hasNext()) {
				BasicDBObject document = new BasicDBObject();
				document = (BasicDBObject) gry_pending_sellbills_cursor.next();
				if (document.getString("issue_date").compareTo(b.issue_date) == 0) 
					buybill_collection.remove(document);
			}
			
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", b.id);
			bill.put("name", b.name);
			bill.put("address", b.address);
			bill.put("phone", b.phone_number);
			bill.put("taker", b.taker);
			bill.put("whighter", b.weighter);
			bill.put("issue_date", b.issue_date);
			bill.put("paid_date", b.paid_date);
			bill.put("product_type", b.product_type);
			bill.put("status", b.status);
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for (Product p : b.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number", p.secret_number);
				product.put("size", p.size);
				product.put("weight", p.weight);
				product.put("price", p.price);
				productList.add(product);
			}
			bill.put("products", productList);
			buybill_collection.insert(bill);
		}

		DBCollection sellbill_collection = database.getCollection("sellbill");
		DBCursor sellbills_cursor = sellbill_collection.find();
		while (sellbills_cursor.hasNext()) {
			BasicDBObject document = new BasicDBObject();
			document = (BasicDBObject) sellbills_cursor.next();
			if (document.getString("issue_date").compareTo(APPdate) == 0)
				sellbill_collection.remove(document);
		}

		for (Sellbill s : BillCollections.sellbill) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", s.id);
			bill.put("name", s.name);
			bill.put("address", s.address);
			bill.put("phone", s.phone_number);
			bill.put("issue_date", s.issue_date);
			bill.put("paid_date", s.paid_date);
			bill.put("product_type", s.product_type);
			bill.put("status", s.status);
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for (Product p : s.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number", p.secret_number);
				product.put("size", p.size);
				product.put("weight", p.weight);
				product.put("price", p.price);
				productList.add(product);
			}
			bill.put("products", productList);
			sellbill_collection.insert(bill);
		}
		
		for (Sellbill s : BillCollections.get_pending_sellbill) {
			
			DBCursor get_pending_sellbills_cursor = sellbill_collection.find();
			while (get_pending_sellbills_cursor.hasNext()) {
				BasicDBObject document = new BasicDBObject();
				document = (BasicDBObject) get_pending_sellbills_cursor.next();
				if (document.getString("issue_date").compareTo(s.issue_date) == 0) 
					sellbill_collection.remove(document);
			}
			
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", s.id);
			bill.put("name", s.name);
			bill.put("address", s.address);
			bill.put("phone", s.phone_number);
			bill.put("issue_date", s.issue_date);
			bill.put("paid_date", s.paid_date);
			bill.put("product_type", s.product_type);
			bill.put("status", s.status);
			ArrayList<BasicDBObject> productList = new ArrayList<BasicDBObject>();
			for (Product p : s.product) {
				BasicDBObject product = new BasicDBObject();
				product.put("secret_number", p.secret_number);
				product.put("size", p.size);
				product.put("weight", p.weight);
				product.put("price", p.price);
				productList.add(product);
			}
			bill.put("products", productList);
			sellbill_collection.insert(bill);
		}


		DBCollection expenditure_collection = database.getCollection("expenditure");
		DBCursor expenditure_cursor = expenditure_collection.find();
		while (expenditure_cursor.hasNext()) {
			BasicDBObject document = new BasicDBObject();
			document = (BasicDBObject) expenditure_cursor.next();
			if (document.getString("issue_date").compareTo(APPdate) == 0)
				expenditure_collection.remove(document);
		}

		for (Expenditure e : External.expenditure) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", e.id);
			bill.put("list", e.list);
			bill.put("amount", e.amount);
			bill.put("issue_date", e.issue_date);
			expenditure_collection.insert(bill);
		}

		DBCollection revenue_collection = database.getCollection("revenue");
		DBCursor revenue_cursor = revenue_collection.find();
		while (revenue_cursor.hasNext()) {
			BasicDBObject document = new BasicDBObject();
			document = (BasicDBObject) revenue_cursor.next();
			if (document.getString("issue_date").compareTo(APPdate) == 0)
				revenue_collection.remove(document);
		}

		for (Revenue r : External.revenue) {
			BasicDBObject bill = new BasicDBObject();
			bill.put("id", r.id);
			bill.put("list", r.list);
			bill.put("amount", r.amount);
			bill.put("issue_date", r.issue_date);
			revenue_collection.insert(bill);
		}

	}

	public static void LoadData() {

		System.out.println("	! ! ! LOAD DATA ! ! !");

		Mongo mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "krupunya", "password".toCharArray());
		System.out.println("Connected to the database successfully");
		DB database = mongo.getDB("krupunya");
		System.out.println("Credentials ::" + credential);

		String APPdate = dateIn.year + dateIn.month + dateIn.day;

		DBCollection buybill_collection = database.getCollection("buybill");
		DBCursor buybills_cursor = buybill_collection.find();
		while (buybills_cursor.hasNext()) {
			BasicDBObject bill = (BasicDBObject) buybills_cursor.next();
			if (bill.getString("issue_date").compareTo(APPdate) == 0) {
				Buybill b = new Buybill();
				b.id = bill.getString("id");
				b.name = bill.getString("name");
				b.address = bill.getString("address");
				b.phone_number = bill.getString("phone");
				b.taker = bill.getString("taker");
				b.weighter = bill.getString("weighter");
				b.issue_date = bill.getString("issue_date");
				b.paid_date = bill.getString("paid_date");
				b.product_type = bill.getString("product_type");
				b.status = bill.getBoolean("status");
				ArrayList<BasicDBObject> products = (ArrayList<BasicDBObject>) bill.get("products");
				for (BasicDBObject product : products) {
					Product p = new Product();
					p.secret_number = product.getString("secret_number");
					p.size = product.getInt("size");
					p.weight = product.getDouble("weight");
					p.price = product.getDouble("price");
					b.product.add(p);
				}
				BillCollections.buybill.add(b);
			}

			if (bill.getBoolean("status") == false) {
				Buybill b = new Buybill();
				b.id = bill.getString("id");
				b.name = bill.getString("name");
				b.address = bill.getString("address");
				b.phone_number = bill.getString("phone");
				b.taker = bill.getString("taker");
				b.weighter = bill.getString("weighter");
				b.issue_date = bill.getString("issue_date");
				b.paid_date = bill.getString("paid_date");
				b.product_type = bill.getString("product_type");
				b.status = bill.getBoolean("status");
				ArrayList<BasicDBObject> products = (ArrayList<BasicDBObject>) bill.get("products");
				for (BasicDBObject product : products) {
					Product p = new Product();
					p.secret_number = product.getString("secret_number");
					p.size = product.getInt("size");
					p.weight = product.getDouble("weight");
					p.price = product.getDouble("price");
					b.product.add(p);
				}
				BillCollections.pending_buybill.add(b);
			}

			if (bill.getBoolean("status") == true) {
				if ((bill.getString("paid_date").compareTo(APPdate) == 0) && (bill.getString("paid_date").compareTo(bill.getString("issue_date")) != 0)) {
					Buybill b = new Buybill();
					b.id = bill.getString("id");
					b.name = bill.getString("name");
					b.address = bill.getString("address");
					b.phone_number = bill.getString("phone");
					b.taker = bill.getString("taker");
					b.weighter = bill.getString("weighter");
					b.issue_date = bill.getString("issue_date");
					b.paid_date = bill.getString("paid_date");
					b.product_type = bill.getString("product_type");
					b.status = bill.getBoolean("status");
					ArrayList<BasicDBObject> products = (ArrayList<BasicDBObject>) bill.get("products");
					for (BasicDBObject product : products) {
						Product p = new Product();
						p.secret_number = product.getString("secret_number");
						p.size = product.getInt("size");
						p.weight = product.getDouble("weight");
						p.price = product.getDouble("price");
						b.product.add(p);
					}
					BillCollections.pay_pending_buybill.add(b);
				}
			}
		}

	}
}
