package contain;

public class Handle<T> {
	public T t;
	public Handle(){
		
	}
	public Handle(T tt){
		this.t=tt;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
/*	class Person{
		private String sex;
		Person(){
		}
		Person(String s){
		sex=s;	
		}
	}*/
	public static void main(String[] args){
		
		Handle<String> hstring=new Handle<String>();
		
		Handle<HashSetTest> hperson=new Handle<HashSetTest>(
				new HashSetTest("BeiJing Yanan load 23")
				);
		
		HashSetTest hst=hperson.getT();
		
		hst.print();
	}

}
