package supershop;

import java.util.ArrayList;
import java.util.Scanner;

import supershop.casheir;
import supershop.customer;
import supershop.product;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		casheir obj1 = new casheir();
		obj1.setdata("Rahim" , 1001, 25,"Male");
		obj1.setSalaryNexp(10000,2);
		casheir obj2 = new casheir();
		obj2.setdata("Karim" , 1002, 20,"Male");
		obj2.setSalaryNexp(150000,3);
		casheir obj3 = new casheir();
		obj3.setdata("Rahima" , 1003, 29,"Female");
		obj3.setSalaryNexp(20000,5);

		System.out.println("----------MEENA BAZAR----------");
		System.out.println("----------Enter todays product detail----------");
		System.out.println("Enter how many product detail you wanna insert ");                                                                                     
		int num = sc.nextInt();
		sc.nextLine();
		for(int i =0;i<num;i++) {
			System.out.println("Enter Product Name :");
			String productName = sc.nextLine();
			
			System.out.println("Enter stock number ");
			int stock = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter category Name :");
			String category = sc.nextLine();
			
			System.out.println("Enter Product ID ");
			int productid = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Product Price ");
			int productprice = sc.nextInt();
			sc.nextLine();
			
			productDetail c1 = new productDetail(productprice , productid);
			product c2 = new product();
			c2.set_product(productName , category , c1);
			c2.set_stock( stock);
			productStore.productlist.add(c2);
			
		}

		System.out.println("Enter your Casheir ID(1001/1002/1003):");
		int casheir_id = sc.nextInt();
		sc.nextLine();
		while(1>0){
			System.out.println("Enter    0:Break     1:Add Customer   2:Delete customer   3:Bill ");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice == 0) {
				System.out.println("------------ THANK YOU -----------");
				break;
			}
			if(choice == 1) {
				System.out.println("Enter Customer Name :");
				String customerName = sc.nextLine();
				System.out.println("Enter Customer ID ");
				int customerid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Customer age ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Customer Gender ");
				String gender = sc.nextLine();
				System.out.println("Enter Customers membership_type");
				String membership_type = sc.nextLine();
				
				customer c = new customer();
				c.setdata(customerName, customerid, age, gender);
				c.set_membership(membership_type);
				
				customerstore.customers.add(c);        
				System.out.println("Customer added successfully.");
				
		}
			if(choice == 2) {
				System.out.println("Enter the ID you wanna delete.");
				int dlt_id = sc.nextInt();
				sc.nextLine();
				for(int i=0;i<customerstore.customers.size();i++) {
					if(customerstore.customers.get(i).getid() ==dlt_id) {
						customerstore.customers.remove(i);
						System.out.println("Removed successfully ");
						break;
					}
					
				}
			}
        if(choice == 3) {

            productStore.boughtProduct.clear();
        	ArrayList<Integer> qunt = new ArrayList<>();
        	
        	System.out.println("Enter Customer Name :");
			String customerName = sc.nextLine();
			System.out.println("there are "+ productStore.productlist.size()+" Items.");
			System.out.println("Enter how many items customer wanna buy ");
			int num_of_item = sc.nextInt();
			sc.nextLine();
			
			int sum = 0;			
			for(int i=0;i<num_of_item;i++) {
				System.out.println("Enter product name ");
				String name_of_product = sc.nextLine();
				product proObj = null;
				for(int j = 0; j < productStore.productlist.size(); j++) {

				    product p = productStore.productlist.get(j);

				    if(p.getname().equals(name_of_product)) {
				        proObj = p;
				        break;
				    }
				}
				
				if(proObj != null) {
					System.out.println("Enter quantity of product ");
					int num_of_product = sc.nextInt();
					sc.nextLine();
					if(num_of_product<=proObj.getstock()) {
						System.out.println("Product is available ");
						proObj.set_stock(num_of_product);
						sum+=proObj.getprice()*num_of_product;
						
						productStore.boughtProduct.add(proObj);
						qunt.add(num_of_product);
						
					}
					else {
						System.out.println("stock out ");
					}
				}
				else {
					System.out.println("Product is not available ");
				}
			}
			
			double discount = 0;
			double total =  0;
			sc.nextLine();
			
			customer cusObj = null;

			for(customer c : customerstore.customers) {
			    if(c.getname().equals(customerName)) {
			        cusObj = c;
			        break;
			    }
			}
			if(cusObj!=null) {
				if(cusObj.get_membership().equals("Advance")) {
					discount = sum* (0.05);
				}
				else if(cusObj.get_membership().equals("Premium")) {
					discount = sum* (0.2);
				}
				else {
					discount = 0.00;
				}
			}
			else {
				discount = 0.00;
			}
			total= sum-discount;
			
			
			System.out.println("-------Cash Memo-------");
			if(casheir_id==1001) {
				System.out.println("Casheir Name "+obj1.getname());
			    System.out.println("Casheir ID "+obj1.getid());
			}
			else if(casheir_id==1002) {
				System.out.println("Casheir Name "+obj2.getname());
			    System.out.println("Casheir ID "+obj2.getid());
				}
			else if(casheir_id==1003) {
				System.out.println("Casheir Name "+obj3.getname());
			    System.out.println("Casheir ID "+obj3.getid());
				}
			if(cusObj != null) {
			    System.out.println("Customer Name "+cusObj.getname());
			    System.out.println("Customer ID "+cusObj.getid());
			}
			else {
			    System.out.println("Customer not found.");
			}
			System.out.println("------------ PURCHASED PRODUCTS -----------");
			for(int i=0;i<productStore.boughtProduct.size();i++) {
				product p = productStore.boughtProduct.get(i);
				int q = qunt.get(i);
				
				System.out.println("Product name "+ p.getname());
				System.out.println("Product price "+ p.getprice());
				System.out.println("Product quantity "+ q);
				System.out.println("-------------X-----------");
			}
			
			System.out.println("Discount "+ discount);
			System.out.println("Total bill "+ total);
			System.out.println("------------ HAPPY SHOPPING -----------");
			
			
        }
		}
		
				

	}

}
