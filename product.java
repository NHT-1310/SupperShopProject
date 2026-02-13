package supershop;

public class product {
	String name,category;
	int stock;
	productDetail obj;
	
	public product() {
		// TODO Auto-generated constructor stub
	}


	void set_product(String name,String category, productDetail obj ){
		this.name = name;
		
		this.category = category;
		this.obj = obj;
	}
	
	void set_stock( int stock) {
		this.stock = stock;
	}
	int getstock() {
		return stock;
	}
	int getprice() {
		return obj.price;
	}
	int getid() {
		return obj.id;
	}

	public String getname() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
