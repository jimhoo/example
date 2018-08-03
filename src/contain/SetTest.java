package contain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import sun.misc.Compare;
/*
 * 　
Set是一种不包含重复的元素的Collection，即任意的两个元素e1和e2都有e1.equals(e2)=false，Set最多有一个null元素。 
很明显，Set的构造函数有一个约束条件，传入的Collection参数不能包含重复的元素。 
请注意：必须小心操作可变对象（Mutable Object）。如果一个Set中的可变元素改变了自身状态导致Object.equals(Object)=true将导致一些问题。

HashSet : HashSet类按照哈希算法来存取集合中的对象，存取速度比较快
TreeSet : TreeSet类实现了SortedSet接口，能够对集合中的对象进行排序。 
需要重写hasCode equals
*/

import com.sun.org.glassfish.external.statistics.Statistic;


public class SetTest {
	/**
	 * @param args
	 */
	static class User{
		private int age;
		private String name;
		User(int age,String name){
			this.age=age;
			this.name=name;
		}
		public String toString(){
			System.out.println("User age:"+age+"; name:"+name);
			return "{age:"+age+";name:"+name+"}";
		}
	}
	static class Person{
		private int age;
		private String name;
		public Person(int age,String name) {
			this.age=age;
			this.name=name;
		}
		public String toString(){
			System.out.println("Person age:"+age+"; name:"+name);
			return "{age:"+age+";name:"+name+"}";
		}
		@Override
		public int hashCode() {
			/*Person p=(Person) this;*/
	        return age+name.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) return true;
			if(obj==null) return false;
			if(this.getClass()!=obj.getClass()) return false;
			Person other=(Person) obj;
			if(other.age!=age) return false;
			if(other.name!=name) return false;
			return true;
		}
	}
	
	public static void PersonSetTest01(){
		Set<Person> pSet=new HashSet<SetTest.Person>(){{
			add(new Person(21, "name21"));
			add(new Person(23, "name23"));
			add(new Person(22, "name22"));
			add(new Person(20, "name20"));
			add(new Person(26, "name26"));
			add(new Person(24, "name24"));
		}};
		pSet.add(new Person(20, "name20"));
		for(Object p:pSet){
			((Person) p).toString();
		}
	}
	
/*
 * TreeSet 排序集合，添加对象时，需要对比函数。
 * */	
	public static void TreeSetTest01(){
		Set set=new TreeSet<User>(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.age-o2.age;
			}
		});
		set.add(new User(21, "name21"));
		set.add(new User(23, "name23"));
		set.add(new User(22, "name22"));
		set.add(new User(20, "name20"));
		set.add(new User(26, "name26"));
		set.add(new User(24, "name24"));
		for(Object user:set){
			System.out.println("set:"+((User) user).toString());
		}
	}
	
	public static void SetTest01(){
		Set set=new HashSet<String>(){{
			add("String03");
			add("String01");
			add("String02");
			add("String08");
			add("String04");
			add("String05");
			}};
		System.out.println("Set:"+set);
		set.add("String02");
		System.out.println("Set:"+set);
		set.remove("String08");
		System.out.println("Set:"+set);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonSetTest01();
		TreeSetTest01();
	}

}
