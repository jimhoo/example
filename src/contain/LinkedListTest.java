package contain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
LinkedList类是双向列表,列表中的每个节点都包含了对前一个和后一个元素的引用.
LinkedList实现了List接口，允许null元素。此外LinkedList提供额外的get，remove，insert方法在 LinkedList的首部或尾部。这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）。
(01) LinkedList 实际上是通过双向链表去实现的。
	它包含一个非常重要的内部类：Entry。Entry是双向链表节点所对应的数据结构，它包括的属性有：当前节点所包含的值，上一个节点，下一个节点。
(02) 从LinkedList的实现方式中可以发现，它不存在LinkedList容量不足的问题。
(03) LinkedList的克隆函数，即是将全部元素克隆到一个新的LinkedList对象中。
(04) LinkedList实现java.io.Serializable。当写入到输出流时，先写入“容量”，再依次写入“每一个节点保护的值”；当读出输入流时，先读取“容量”，再依次读取“每一个元素”。
	        第一个元素（头部）                 最后一个元素（尾部）
	        抛出异常        特殊值            抛出异常        特殊值
	插入    addFirst(e)    offerFirst(e)    addLast(e)        offerLast(e)
	移除    removeFirst()  pollFirst()      removeLast()    pollLast()
	检查    getFirst()     peekFirst()      getLast()        peekLast()
(05) 由于LinkedList实现了Deque，而Deque接口定义了在双端队列两端访问元素的方法。提供插入、移除和检查元素的方法。每种方法都存在两种形式：一种形式在操作失败时抛出异常，另一种形式返回一个特殊值（null 或 false，具体取决于操作）。
(06) LinkedList可以作为FIFO(先进先出)的队列，作为FIFO的队列时，下表的方法等价：
	队列方法       等效方法
	add(e)        addLast(e)
	offer(e)      offerLast(e)
	remove()      removeFirst()
	poll()        pollFirst()
	element()     getFirst()
	peek()        peekFirst()
(07) LinkedList可以作为LIFO(后进先出)的栈，作为LIFO的栈时，下表的方法等价：
	栈方法        等效方法
	push(e)      addFirst(e)
	pop()        removeFirst()
	peek()       peekFirst()

特殊的队列叫做PriorityQueue

add(E e)和offer(E e)的语义相同，都是向优先队列中插入元素，只是Queue接口规定二者对插入失败时的处理不同，前者在插入失败时抛出异常，后则则会返回false。对于PriorityQueue这两个方法其实没什么差别。
element()和peek()语义完全相同，都是获取但不删除队首元素，也就是队列中权值最小的那个元素，二者唯一的区别是当方法失败时前者抛出异常，后者返回null。根据小顶堆的性质，堆顶那个元素就是全局最小的那个；由于堆用数组表示，根据下标关系，0下标处的那个元素既是堆顶元素。所以直接返回数组0下标处的那个元素即可
remove()和poll()方法的语义也完全相同，都是获取并删除队首元素，区别是当方法失败时前者抛出异常，后者返回null。由于删除操作会改变队列的结构，为维护小顶堆的性质，需要进行必要的调整。

比較類Comparator
Collections.sort(userList, new Comparator<User>(){
	public int compare(User o1, User o2) {
		return o1.id-o2.id;
		};
	});
分組類Drive

1. public LinkedList():  ——生成空的链表
2. public LinkedList(Collection col):  复制构造函数
 * */
public class LinkedListTest {
	
	public static class User{
	private int	id;
	private String name;

	public User(int id,String name){
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString(){
		System.out.println("User's Id:"+this.id+"; Name:"+this.name);
		return "{Id:"+this.id+"Name+"+this.name+"}";
	}
	}

	private static final int User = 0;
	private static final int List = 0;
	
	public static void CompareOfUse(){
		
		List userList=new ArrayList<User>(){{
				add(new User(12,"jack"));
				add(new User(11,"tom"));
				add(new User(12,"janne"));
				add(new User(13,"jimmes"));
				add(new User(11,"mom"));
				}};
				
		Collections.sort(userList, new Comparator<User>(){
			public int compare(User o1, User o2) {
				return o1.id-o2.id;
				};
			});
		for(int i=0;i<userList.size();i++){
			User user=(User) userList.get(i);
			System.out.println(user.toString());
		}
		System.out.println("=======================");
		for(Object user:userList){
			System.out.println(((User) user).toString());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriortyQueueOfLinkedList();
//		CompareOfUse();
	}

	public static void PriortyQueueOfLinkedList(){
		List<String> list=new ArrayList<String>(){{
			add("aaaa");
			add("bbbb");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		/*单向队列：用List初始化 队列queue 队列*/
		Queue<User> priorityQueue=new PriorityQueue<LinkedListTest.User>(11, new Comparator<User>() {
			@Override
			public int compare(contain.LinkedListTest.User o1,
					contain.LinkedListTest.User o2) {
				// TODO Auto-generated method stub
				return o1.id-o2.id;
			};
		}){{
			add(new User(12,"jack"));
			add(new User(11,"tom"));
			add(new User(12,"janne"));
			add(new User(13,"jimmes"));
			add(new User(11,"mom"));
		}};

		
/*		Collections.sort(priorityQueue, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.id-o2.id;
			};
		});*/
	
		
		while(!priorityQueue.isEmpty()){
			User user=priorityQueue.poll();
			System.out.println("priority queue node:"+user.toString());
		}
		/*element()和peek()
		 * */
		/*add和offer的区别，add抛异常,offer返回false*/

		

	}

	public static void QueueOfLinkedList(){
		List<String> list=new ArrayList<String>(){{
			add("aaaa");
			add("bbbb");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		/*单向队列：用List初始化 队列queue 队列*/
		Queue<String> queue=new PriorityQueue<String>(list);
		System.out.println("queue"+queue);
		/*element()和peek()
		 * */
		/*add和offer的区别，add抛异常,offer返回false*/
		queue.add("bbbb");
		
		System.out.println("queue"+queue);
	}
	
	public static void LinkedListFIFO(){
		List<String> list=new ArrayList<String>(){{
			add("aaaa");
			add("bbbb");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		/*双向队列：用List初始化 队列deque*/
		Deque<String> deque=new LinkedList<String>(list);
		System.out.println("deque"+deque);
	}
	
	public static void LinkedListLIFO(){
		List<String> list=new ArrayList<String>(){{
			add("aaaa");
			add("bbbb");
			add("cccc");
			add("dddd");
			add("eeee");
		}};
		/*用List初始化 队列deque*/
/*		Stack<String> stack=new LinkedList();
		
		System.out.println("stack"+stack);*/
	}

}
