package data;

import java.util.ArrayList;

public class Buybill {
	
	public String id;
	public String name;
	public String address;
	public String phone_number;
	public String taker;
	public String weighter;
	public String issue_date;
	public String paid_date;
	public String product_type;
	public boolean status; // true = paid ; flase = pending
	public ArrayList <Product> product = new ArrayList<Product>(); //secret_number,size,weight,price

}
