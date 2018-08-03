package contain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListTest {

/*
ArrayList它的优点在于随机访问元素快，但是在中间插入和移除比较慢
1\初始化
初始化ArrayList的两种方法
方式一：
  ArrayList<String> list = new ArrayList<String>();
  String str01 = String("str01");
  String str02 = String("str02");
  list.add(str01);
  list.add(str02);
方式二：
  ArrayList<String> list = new ArrayList<String>(){{add("str01"); add("str02");}};  
2\增、删、改、查
查询:indexof(object) 返回第一个查询到的结果（多个的情况）,没查询到，返回-1;


改:
set

通过iterator删除 

ArrayList转换为数组 ，数组转换为ArrayList
	arrayList01.toArray(array01);
数组转换为List
	list=Arrays.asList(array01);
	
List复制
List listCopy=new ArrayList();
listCopy.addAll(list);

List复制 ： List listCopy01=new ArrayList(list);

 * */
	public static void ArrayListInitTest(){
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		ArrayList<Integer> array02=new ArrayList<Integer>(){{
			add(31);
			add(31);
			add(41);
			add(50);
		}};
		int[] int01={53,21,10,24,5};
		int[] int02=new int[10];
		arrayList.add(21);
		arrayList.add(21);
		arrayList.add(31);
		arrayList.add(10);
		
		System.out.println("arrayList:"+arrayList);
		System.out.println("arrayList02:"+array02);
	}
	
	
	public static void ArrayListIndexOfTest(){
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		ArrayList<Integer> array02=new ArrayList<Integer>(){{
			add(31);
			add(31);
			add(41);
			add(50);
		}};
		int[] int01={53,21,10,24,5};
		int[] int02=new int[10];
		arrayList.add(21);
		arrayList.add(21);
		arrayList.add(31);
		arrayList.add(10);
//		ArrayList subList01=(ArrayList<Integer>) arrayList.subList(0, arrayList.size());
		arrayList.subList(0, arrayList.size());
		//查询一个
		
		ArrayList<Integer> arrSub02=new ArrayList<Integer>(){
			{
				add(21);add(21);
			}
		};
		ArrayList<Integer> idxof=new ArrayList<Integer>();
		
		int idx=arrayList.indexOf(21);
		
		arrayList.containsAll(arrSub02);
		System.out.println("index:"+idx);
		System.out.println("arrayList:"+arrayList);
		System.out.println("arrayList02:"+array02);
		/*查询*/
		System.out.println("查询到210第一个出现的位置:"+arrayList.indexOf(210));
		ArrayList<Integer> pointList=new ArrayList<Integer>();
		for(int i=0;i<arrayList.size();i++){
			if(arrayList.get(i)==21) pointList.add(i);
		}
		System.out.println("查询到21出现的所有位置:"+pointList);
		System.out.println("判断是否包含元素21:"+arrayList.contains(21));
		
		System.out.println("判断是否包含arrsub02子集:"+arrayList.containsAll(arrSub02));
		System.out.println("subList01:"+arrayList.subList(0+1, arrayList.size()));
		/*删除操作：
		 * 首先要判断是否存在，只有存在才可以删除；
		 * 否则会报错*/
		Object o=(Object) 31;
		if(array02.indexOf(o)!=-1) array02.remove(o);
		System.out.println("arrayList02:"+array02);
		/*增加元素方法:位置,值*/
		arrayList.add(1, 210);
		System.out.println("arrayList:"+arrayList);
	}

	
	public static void ArrayListIteratorTest(){
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		ArrayList<Integer> array02=new ArrayList<Integer>(){{
			add(31);
			add(31);
			add(41);
			add(50);
		}};
		int[] int01={53,21,10,24,5};
		int[] int02=new int[10];
		arrayList.add(21);
		arrayList.add(21);
		arrayList.add(31);
		arrayList.add(10);
//		ArrayList subList01=(ArrayList<Integer>) arrayList.subList(0, arrayList.size());
		arrayList.subList(0, arrayList.size());
		//查询一个
		ArrayList<Integer> arrSub02=new ArrayList<Integer>(){
			{
				add(21);add(21);
			}
		};
		ArrayList<Integer> idxof=new ArrayList<Integer>();
		
		int idx=arrayList.indexOf(21);
		
		arrayList.containsAll(arrSub02);
		System.out.println("index:"+idx);
		System.out.println("arrayList:"+arrayList);
		System.out.println("arrayList02:"+array02);
		/*查询*/
		System.out.println("查询到210第一个出现的位置:"+arrayList.indexOf(210));
		ArrayList<Integer> pointList=new ArrayList<Integer>();
		for(int i=0;i<arrayList.size();i++){
			if(arrayList.get(i)==21) pointList.add(i);
		}
		System.out.println("查询到21出现的所有位置:"+pointList);
		System.out.println("判断是否包含元素21:"+arrayList.contains(21));
		
		System.out.println("判断是否包含arrsub02子集:"+arrayList.containsAll(arrSub02));
		System.out.println("subList01:"+arrayList.subList(0+1, arrayList.size()));
		/*删除操作：
		 * 首先要判断是否存在，只有存在才可以删除；
		 * 否则会报错*/
		Object o=(Object) 31;
		if(array02.indexOf(o)!=-1) array02.remove(o);
		System.out.println("arrayList02:"+array02);
		/*增加元素方法:位置,值*/
		arrayList.add(1, 210);
		System.out.println("arrayList:"+arrayList);
		
		
		/*
		 *通过iterator删除 
		 * */

		Iterator it=arrayList.listIterator();
		while(it.hasNext()){
//		System.out.println( it.next().equals((Object) 21) ) ;
			if( it.next().equals( (Object) 21 ) ) 
				it.remove(); 
		}
		System.out.println("arrayList:"+arrayList);
	}	
	/*ArrayList复制为数组*/
	public static void ArrayListToArrayTest(){
		ArrayList<Integer> arrayList01=new ArrayList<Integer>(){{
			add(31);
			add(31);
			add(41);
			add(50);
		}};
		Integer[] array01=new Integer[arrayList01.size()];
		/*List to Array 重点这句*/
		arrayList01.toArray(array01);
		
		for(int i=0;i<array01.length;i++){
			System.out.println(array01[i]);
		}
		/*Array to List 数组转换为List*/
		List list =new ArrayList();
		list=Arrays.asList(array01);
		List listCopy=new ArrayList();
		List listCopy01=new ArrayList(list);
		/*复制List*/
		listCopy.addAll(list);
		System.out.println("List:"+list);
		System.out.println("listCopy:"+list);
		System.out.println("listCopy01:"+listCopy01);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayListInitTest();
//		ArrayListIndexOfTest();
		ArrayListIteratorTest();
		ArrayListToArrayTest();
	}

}
