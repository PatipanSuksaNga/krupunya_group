package process;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;

import data.*;

public class DatabaseHandler {

	private static DB database = DBConection();
	private static DBCollection buybill_collection = database.getCollection("buybill");
	private static DBCollection sellbill_collection = database.getCollection("sellbill");
	private static DBCollection expenditure_collection = database.getCollection("expenditure");
	private static DBCollection revenue_collection = database.getCollection("revenue");

	public static DB DBConectionOnline() {
		String template = "mongodb://krupanya:plug1995@docdb-2019-07-29-06-05-00.cluster-ckblogzdolfc.us-east-2.docdb.amazonaws.com:27017";
		String connectionString = String.format(template);
		MongoClientURI clientURI = new MongoClientURI(connectionString);
		MongoClient mongoClient = new MongoClient(clientURI);
		DB database = mongoClient.getDB("krupanya");
		return database;
	}

	public static DB DBConection() {
		Mongo mongo = new MongoClient("localhost", 27017);
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "krupunya", "password".toCharArray());
		System.out.println("Connected to the database successfully");
		System.out.println("Credentials ::" + credential);
		DB database = mongo.getDB("krupanya");
		return database;
	}

	public static void UpdateBillStatus(String bill_id, boolean updated_status, String paid_date,
			String collection_name) {
		DBCollection bill_collection = database.getCollection(collection_name);
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("status", updated_status).append("paid_date", paid_date));
		BasicDBObject searchQuery = new BasicDBObject().append("id", bill_id);
		bill_collection.update(searchQuery, newDocument);
	}

	public static void PushMember() {

	}

	public static void DeleteInst() {

	}

	private static BasicDBObject BuybillToBasicDBObject(Buybill b) {
		BasicDBObject bill = new BasicDBObject();
		bill.put("id", "SAVED");
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
		return bill;
	}

	private static BasicDBObject SellbillToBasicDBObject(Sellbill s) {
		BasicDBObject bill = new BasicDBObject();
		bill.put("id", "SAVED");
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
		return bill;
	}

	private static BasicDBObject ExpbillToBasicDBObject(Expenditure e) {
		BasicDBObject bill = new BasicDBObject();
		bill.put("id", "SAVED");
		bill.put("list", e.list);
		bill.put("amount", e.amount);
		bill.put("issue_date", e.issue_date);
		return bill;
	}

	private static BasicDBObject RevbillToBasicDBObject(Revenue r) {
		BasicDBObject bill = new BasicDBObject();
		bill.put("id", "SAVED");
		bill.put("list", r.list);
		bill.put("amount", r.amount);
		bill.put("issue_date", r.issue_date);
		return bill;
	}

	private static Buybill BasicDBOblectToBuybill(BasicDBObject bill) {

		Buybill b = new Buybill();

		b.id = bill.getObjectId("_id").toString();
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("id", bill.getObjectId("_id").toString()));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", bill.getObjectId("_id"));
		buybill_collection.update(searchQuery, newDocument);

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
		return b;
	}

	private static Sellbill BasicDBOblectToSellbill(BasicDBObject bill) {

		Sellbill b = new Sellbill();

		b.id = bill.getObjectId("_id").toString();
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("id", bill.getObjectId("_id").toString()));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", bill.getObjectId("_id"));
		sellbill_collection.update(searchQuery, newDocument);

		b.name = bill.getString("name");
		b.address = bill.getString("address");
		b.phone_number = bill.getString("phone");
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

		return b;
	}

	private static Expenditure BasicDBOblectToExpbill(BasicDBObject bill) {

		Expenditure b = new Expenditure();

		b.id = bill.getObjectId("_id").toString();
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("id", bill.getObjectId("_id").toString()));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", bill.getObjectId("_id"));
		expenditure_collection.update(searchQuery, newDocument);

		b.list = bill.getString("list");
		b.amount = bill.getInt("amount");
		b.issue_date = bill.getString("issue_date");

		return b;
	}

	private static Revenue BasicDBOblectToRevbill(BasicDBObject bill) {

		Revenue b = new Revenue();

		b.id = bill.getObjectId("_id").toString();
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("id", bill.getObjectId("_id").toString()));
		BasicDBObject searchQuery = new BasicDBObject().append("_id", bill.getObjectId("_id"));
		expenditure_collection.update(searchQuery, newDocument);

		b.list = bill.getString("list");
		b.amount = bill.getInt("amount");
		b.issue_date = bill.getString("issue_date");

		return b;
	}

	public static void PushData() {

		System.out.println("	! ! ! PUSH DATA ! ! !");

		for (Buybill b : BillCollections.buybill) {
			if (b.id.equals("UNSAVE")) {
				buybill_collection.insert(BuybillToBasicDBObject(b));
			}
		}

		for (Buybill b : BillCollections.pay_pending_buybill) {
			if (b.id.equals("UNSAVE")) {
				buybill_collection.insert(BuybillToBasicDBObject(b));
			}
		}

		for (Sellbill s : BillCollections.sellbill) {
			if (s.id.equals("UNSAVE")) {
				sellbill_collection.insert(SellbillToBasicDBObject(s));
			}
		}

		for (Sellbill s : BillCollections.get_pending_sellbill) {
			if (s.id.equals("UNSAVE")) {
				sellbill_collection.insert(SellbillToBasicDBObject(s));
			}
		}

		for (Expenditure e : External.expenditure) {
			if (e.id.equals("UNSAVE")) {
				expenditure_collection.insert(ExpbillToBasicDBObject(e));
			}
		}

		for (Revenue r : External.revenue) {
			if (r.id.equals("UNSAVE")) {
				revenue_collection.insert(RevbillToBasicDBObject(r));
			}
		}

	}

	public static void LoadData() {

		System.out.println("	! ! ! LOAD DATA ! ! !");
		DB database = DBConection();

		String APPdate = dateIn.year + dateIn.month + dateIn.day;

		DBCursor buybills_cursor = buybill_collection.find();
		while (buybills_cursor.hasNext()) {
			BasicDBObject bill = (BasicDBObject) buybills_cursor.next();
			if (bill.getString("issue_date").compareTo(APPdate) == 0) {
				BillCollections.buybill.add(BasicDBOblectToBuybill(bill));
			}
			if (bill.getBoolean("status") == false) {
				BillCollections.pending_buybill.add(BasicDBOblectToBuybill(bill));
			}

			if (bill.getBoolean("status") == true) {
				if ((bill.getString("paid_date").compareTo(APPdate) == 0)
						&& (bill.getString("paid_date").compareTo(bill.getString("issue_date")) != 0)) {
					BillCollections.pay_pending_buybill.add(BasicDBOblectToBuybill(bill));
				}
			}
		}

		DBCursor sellbills_cursor = sellbill_collection.find();
		while (sellbills_cursor.hasNext()) {
			BasicDBObject bill = (BasicDBObject) sellbills_cursor.next();
			if (bill.getString("issue_date").compareTo(APPdate) == 0) {
				BillCollections.sellbill.add(BasicDBOblectToSellbill(bill));
			}

			if (bill.getBoolean("status") == false) {
				BillCollections.sellbill.add(BasicDBOblectToSellbill(bill));
			}

			if (bill.getBoolean("status") == true) {
				if ((bill.getString("paid_date").compareTo(APPdate) == 0)
						&& (bill.getString("paid_date").compareTo(bill.getString("issue_date")) != 0)) {
					BillCollections.sellbill.add(BasicDBOblectToSellbill(bill));
				}
			}
		}

		DBCollection expenditure_collection = database.getCollection("expenditure");
		DBCursor expenditure_cursor = expenditure_collection.find();
		while (expenditure_cursor.hasNext()) {
			BasicDBObject bill = (BasicDBObject) expenditure_cursor.next();
			if (bill.getString("issue_date").compareTo(APPdate) == 0) {
				External.expenditure.add( BasicDBOblectToExpbill(bill));
			}
		}

		DBCollection revenue_collection = database.getCollection("revenue");
		DBCursor revenue_cursor = revenue_collection.find();
		while (revenue_cursor.hasNext()) {
			BasicDBObject bill = (BasicDBObject) revenue_cursor.next();
			if (bill.getString("issue_date").compareTo(APPdate) == 0) {
				External.revenue.add(BasicDBOblectToRevbill(bill));
			}
		}

	}
}
