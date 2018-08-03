package contain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import contain.HashSetTest.Name;

public class HashSetTest {
	private String address;
	/**
	 * @param args
	 */
	HashSetTest(){
		
	}
	HashSetTest(String a){
		address=a;
	}
	public void print(){
		System.out.println("address:"+address);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Name> set=new HashSet<HashSetTest.Name>();
		Set<String> st=new HashSet<String>();
		st.add("jack");
		st.add("tom");
		st.add("jack");
		
		HashSetTest hst=new HashSetTest();
		
		set.add(hst.new Name("jack", "Tome"));

		set.add(hst.new Name("jack1", "Tome1"));
		Name n=hst.new Name("j", "l");
		set.add(n);
		n.setFirstName("jk");
		n.setLastName("lt");
		set.add(n);
		Iterator<Name> it= set.iterator();
		while(it.hasNext()){
			Name nm=it.next();
			nm.printData();
		}
/*		
		System.out.println("set:"+set);
		set.add(hst.new Name("jack", "Tome"));
		System.out.println("set:"+set);*/
		System.out.println("set_size:"+set.size());
		System.out.println("st_size:"+st.size());
		for(Name nm:set){
			nm.printData();
		}
		
		HashTest ht1=hst.new HashTest();
		HashTest ht2=hst.new HashTest();
		ht1.setI(1);
		ht2.setI(1);
		Set sht=new HashSet<HashSetTest.HashTest>();
		sht.add(ht1);
		sht.add(ht2);
		System.out.println(ht1.hashCode()==ht2.hashCode());
		System.out.println(ht1.equals(ht2));
		System.out.println(sht);
		System.out.println(sht.size());
	}
	
	class HashTest{
		private int i;
		public HashTest(){
			
		}
		public HashTest(int t){
			i=t;
		}
		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
		public int hashCode(){
			return i%10;
		}
		public boolean equals(Object  object){
	        if (object == null) {  
	            return false;  
	        }  
	        if (object == this) {  
	            return true;  
	        }  
	        if (!(object instanceof HashTest)) {  
	            return false;  
	        }  
	        HashTest other = (HashTest) object;  
	        if (other.getI() == this.getI()) {  
	            return true;  
	        }  
	        return false; 
		}
	}
	
	class Name{
		private String firstName;
		private String LastName;
		public Name(String f,String l) {
			// TODO Auto-generated constructor stub
			this.firstName=f;
			this.LastName=l;
		}
		public void printData(){
			address=firstName+LastName;
			System.out.println("firstName:"+this.firstName);
			System.out.println("LastName:"+this.LastName);
			System.out.println("address:"+address);
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
	}
}
