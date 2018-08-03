package contain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapTest {
/*
	HashMap 初始化话
 * */
	public static void HashMapTest01(){
		Map map=new HashMap<Integer,String>();
		map.put(10, "String03");
		map.put(8, "String02");
		map.put(9, "String06");
		map.put(3, "String05");
		map.put(6, "String01");
		map.put(7,"aaa");
		System.out.println("map:"+map);
		Map map01=new HashMap<Integer,String>(){{
			put(10, "String03");
			put(8, "String02");
			put(9, "String06");
			put(3, "String05");
			put(6, "String01");
		}};
		System.out.println("map01:"+map01);
		Map map02=new HashMap<Integer, String>(map01);
		System.out.println("map02:"+map02);
	}
	
	public static void HashMapTest02(){
		Map map=new HashMap<Integer,String>();
		map.put(10, "String03");
		map.put(8, "String02");
		map.put(9, "String06");
		map.put(3, "String05");
		map.put(6, "String01");
		System.out.println("map:"+map);
		map.put(3, "String05");
		System.out.println("map:"+map);
		Map map01=new HashMap<Integer,String>(){{
			put(10, "String03");
			put(8, "String02");
			put(9, "String06");
			put(3, "String05");
			put(6, "String01");
		}};
		System.out.println("map01:"+map01);
		
		Map map02=new HashMap<Integer, String>(map01);
		System.out.println("map02:"+map02);
		List list=new ArrayList<String>(map.values());
		System.out.println("list:"+list);
		Set set=map.entrySet();
		Set set01=map.keySet();
		System.out.println("entrySet:"+set);
		System.out.println("KeySet:"+set01);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapTest02();
	}

}
