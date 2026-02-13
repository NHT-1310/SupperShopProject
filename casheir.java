package supershop;

public class casheir {
	private String name,gender;
	private int id,age,salary,exp;
	void setdata(String n, int i,int a, String g) {
		name = n;
		id = i;
		age = a;
		gender = g;
	}
	void setSalaryNexp(int s, int e){
		salary= s;
		exp = e;
	}
	
	String getname() {
		
		return name;
	}
	int getid() {
		return id;
	}
}
