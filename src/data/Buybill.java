package data;

import java.util.ArrayList;

public class Buybill {
	
	public String name;
	public String address;
	public String phone_number;
	public String date;
	public String product_type;
	public boolean status; // true = paid ; flase = pending
	
	public double total_price;
	public double total_weight;
	
	public ArrayList <Product> product = new ArrayList<Product>(); //count,secret_number,size,weight,price

}
