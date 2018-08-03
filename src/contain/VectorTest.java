package contain;

import java.util.Stack;
import java.util.Vector;

/*
Vector為同步，其他和ArrayList一樣，因此多線程用Vector比較好些，安全.
 * 

Vector 类提供了实现可增长数组的功能，随着更多元素加入其中，数组变的更大。在删除一些元素之后，数组变小。 
Vector 有三个构造函数， 
public Vector(int initialCapacity,int capacityIncrement) 　　　　　　　　　public Vector(int initialCapacity) 　　　　　　　　　public Vector() 　　Vector 运行时创建一个初始的存储容量initialCapacity，存储容量是以capacityIncrement 变量定义的增量增长。初始的存储容量和capacityIncrement 可以在Vector 的构造函数中定义。第二个构造函数只创建初始存储容量。第三个构造函数既不指定初始的存储容量也不指定capacityIncrement。 　　Vector 类提供的访问方法支持类似数组运算和与Vector 大小相关的运算。类似数组的运算允许向量中增加，删除和插入元素。它们也允许测试矢量的内容和检索指定的元素，与大小相关的运算允许判定字节大小和矢量中元素不数目。 　　现针对经常用到的对向量增，删，插功能举例描述： 
addElement(Object obj)　　 　　把组件加到向量尾部，同时大小加1，向量容量比以前大1 　 
insertElementAt(Object obj, int index)　　 　　把组件加到所定索引处，此后的内容向后移动1 个单位 　 
setElementAt(Object obj, int index) 　　把组件加到所定索引处，此处的内容被代替。 　　removeElement(Object obj) 把向量中含有本组件内容移走。 　　removeAllElements() 把向量中所有组件移走，向量大小为0。 　


1. one　　 2. one　　 3. one　　 4. zero　　 5.zero　　 6. zero　　7. zero 8. 　　　　　 two　　 two　 one　　 one　　 one　　 one 　　　　　　　　　　　three　　 two　　 two　　 two　　 two 　three　　 oop　　 three　　three 　three　　 three　　four 　 　　另外，Vector 在参数传递中发挥着举足轻重的作用。在Applet 中有一块画布(Canvas) 和一个(Panel), 而Panel 中放着用户要输入的信息，根据这些信息把参数传递到canvas 中，这时在Java 中用一个接口（Interface）, 而在接口中需用一个Vector 去传递这些参数。另外，在一个类向另一个类参数传递就可以用这种方法。 　　例如： 　 
import java.util.Vector 
interface codeselect{ Vector codeselect=new Vector(); } 显示数学信息 
Vector(0)存入学生编号 
Vector(1)存入学科 　 　　在Panel 中当用户在TextField 和Choice 中选择自己所要求的内容，程序中通过事件响应把值传到向量Vector 中。

 

同步是个很大的问题,尤其多线程,和进程中,因此,我们在多线程中同时对某个数组操作时,支持同步的vector无疑是个很好的选择，一般在需要将多个元素存在一个集合里的时候用。
java.util 类 Vector<E> 
boolean add(E o) 
将指定元素追加到此向量的末尾。 
void add(int index, E element) 
在此向量的指定位置插入指定的元素。 
boolean addAll(Collection<? extends E> c) 
将指定 Collection 中的所有元素追加到此向量的末尾，按照指定集合的迭代器所返回的顺序追加这些元素。 
boolean addAll(int index, Collection<? extends E> c) 
在指定位置将指定 Collection 中的所有元素插入到此向量中。 
void addElement(E obj) 
将指定的组件添加到此向量的末尾，将其大小增加 1。 
int capacity() 
返回此向量的当前容量。 
void clear() 
从此向量中移除所有元素。 
Object clone() 
返回向量的一个副本。 
boolean contains(Object elem) 
测试指定的对象是否为此向量中的组件。 
boolean containsAll(Collection<?> c) 
如果此向量包含指定 Collection 中的所有元素，则返回 true。 
void copyInto(Object[] anArray) 
将此向量的组件复制到指定的数组中。 
E elementAt(int index) 
返回指定索引处的组件。 
Enumeration<E> elements() 
返回此向量的组件的枚举。 
void ensureCapacity(int minCapacity) 
增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。 
boolean equals(Object o) 
比较指定对象与此向量的相等性。 
E firstElement() 
返回此向量的第一个组件（位于索引 0 处的项）。 
E get(int index) 
返回向量中指定位置的元素。 
int hashCode() 
返回此向量的哈希码值。 
int indexOf(Object elem) 
搜索给定参数的第一个匹配项，使用 equals 方法测试相等性。 
int indexOf(Object elem, int index) 
搜索给定参数的第一个匹配项，从 index 处开始搜索，并使用 equals 方法测试其相等性。 
void insertElementAt(E obj, int index) 
将指定对象作为此向量中的组件插入到指定的 index 处。 
boolean isEmpty() 
测试此向量是否不包含组件。 
E lastElement() 
返回此向量的最后一个组件。 
int lastIndexOf(Object elem) 
返回指定的对象在此向量中最后一个匹配项的索引。 
int lastIndexOf(Object elem, int index) 
向后搜索指定的对象，从指定的索引处开始搜索，并返回一个索引。 
E remove(int index) 
移除此向量中指定位置的元素。 
boolean remove(Object o) 
移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。 
boolean removeAll(Collection<?> c) 
从此向量中移除包含在指定 Collection 中的所有元素。 
void removeAllElements() 
从此向量中移除全部组件，并将其大小设置为零。 
boolean removeElement(Object obj) 
从此向量中移除变量的第一个（索引最小的）匹配项。 
void removeElementAt(int index) 
删除指定索引处的组件。 
protected void removeRange(int fromIndex, int toIndex) 
从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。 
boolean retainAll(Collection<?> c) 
在此向量中仅保留包含在指定 Collection 中的元素。 
E set(int index, E element) 
用指定的元素替换此向量中指定位置处的元素。 
void setElementAt(E obj, int index) 
将此向量指定 index 处的组件设置为指定的对象。 
void setSize(int newSize) 
设置此向量的大小。 
int size() 
返回此向量中的组件数。 
List<E> subList(int fromIndex, int toIndex) 
返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。 
Object[] toArray() 
返回一个数组，包含此向量中以正确顺序存放的所有元素。 
<T> T[] 
toArray(T[] a) 
返回一个数组，包含此向量中以正确顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。 
String toString() 
返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。 
void trimToSize() 
对此向量的容量进行微调，使其等于向量的当前大小。
 * */
public class VectorTest {
	public static void test01(){
		Vector<String> vector=new Vector<String>();
		vector.add("String01");
		vector.add("String03");
		vector.add("String02");
		vector.add("String08");
		vector.add("String05");
		vector.add("String07");
		vector.remove("String03");
		vector.remove(2);
		System.out.println("vector:"+vector);
	}
	
	public void stackTest(){
		Stack<String> stack=new Stack<String>();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}

}
