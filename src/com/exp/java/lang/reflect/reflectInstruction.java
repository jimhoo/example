package com.exp.java.lang.reflect;

import java.awt.print.Printable;

public class reflectInstruction {
class user{
	private String firstName;
	private String lastName;
	private int	age;
	user(String f,String l,int a){
		this.firstName=f;
		this.lastName=l;
		this.age=a;
	}
	void printInfo(){
		String str="Name:"+this.firstName+" "+this.lastName+" ;age:"+this.age;
		System.out.println(str);
	}
}
	public static void main(String[] agrs) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		reflectInstruction ri=new reflectInstruction();
		user u=ri.new user("bond", "Jack", 12);
		u.printInfo();
		Class ric1=Class.forName("user");
		Object rio1=ric1.newInstance();
		ric1.getClassLoader().
	}
}
/*
      二，反射机制的作用：
              1，反编译：.class-->.java
              2,通过反射机制访问java对象的属性，方法，构造方法等；
             这样好像更容易理解一些，下边我们具体看怎么实现这些功能。
 三，在这里先看一下sun为我们提供了那些反射机制中的类：
java.lang.Class;                
java.lang.reflect.Constructor; java.lang.reflect.Field;        
java.lang.reflect.Method;
java.lang.reflect.Modifier;
      很多反射中的方法，属性等操作我们可以从这四个类中查询。还是哪句话要学着不断的查询API，那才是我们最好的老师。
四，具体功能实现：
1，反射机制获取类有三种方法，我们来获取Employee类型
[java] view plain copy
//第一种方式：  
Classc1 = Class.forName("Employee");  
//第二种方式：  
//java中每个类型都有class 属性.  
Classc2 = Employee.class;  
//第三种方式：  
//java语言中任何一个java对象都有getClass 方法  
Employeee = new Employee();  
Classc3 = e.getClass(); //c3是运行时类 (e的运行时类是Employee)
2，创建对象：获取类以后我们来创建它的对象，利用newInstance：
Class c =Class.forName("Employee");  
//创建此Class 对象所表示的类的一个新实例  
Objecto = c.newInstance(); //调用了Employee的无参数构造方法.
3,获取属性：分为所有的属性和指定的属性：
      a，先看获取所有的属性的写法：
//获取整个类  
        Class c = Class.forName("java.lang.Integer");  
          //获取所有的属性?  
        Field[] fs = c.getDeclaredFields();  
   
               //定义可变长的字符串，用来存储属性  
        StringBuffer sb = new StringBuffer();  
        //通过追加的方法，将每个属性拼接到此字符串中  
        //最外边的public定义  
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");  
        //里边的每一个属性  
        for(Field field:fs){  
            sb.append("\t");//空格  
            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等  
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字  
            sb.append(field.getName()+";\n");//属性的名字+回车  
        }  
        sb.append("}");  
        System.out.println(sb); 
b，获取特定的属性，对比着传统的方法来学习：
public static void main(String[] args) throws Exception{    
    /* 
*   User u = new User(); 
*   u.age = 12; //set 
*   System.out.println(u.age); //get 
    */  
/*
    //获取类  
    Class c = Class.forName("User");  
    //获取id属性  
    Field idF = c.getDeclaredField("id");  
    //实例化这个类赋给o  
    Object o = c.newInstance();  
    //打破封装  
    idF.setAccessible(true); //使用反射机制可以打破封装性，导致了java对象的属性不安全。  
    //给o对象的id属性赋值"110"  
    idF.set(o, "110"); //set  
    //get  
    System.out.println(idF.get(o));  
} 
*/
/*
4，获取方法，和构造方法，不再详细描述，只来看一下关键字：
方法关键字
含义
getDeclaredMethods() 获取所有的方法
getReturnType() 获得方法的放回类型
getParameterTypes()获得方法的传入参数类型
getDeclaredMethod("方法名",参数类型.class,……) 获得特定的方法
构造方法关键字
含义
getDeclaredConstructors() 获取所有的构造方法
getDeclaredConstructor(参数类型.class,……) 获取特定的构造方法
父类和父接口
含义
getSuperclass() 获取某类的父类
getInterfaces() 获取某类实现的接口



作者：郭无心
链接：https://www.zhihu.com/question/24304289/answer/76541818
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

Java的反射机制的实现要借助于4个类：class，Constructor，Field，Method;
其中class代表的时类对 象，Constructor－类的构造器对象，Field－类的属性对象，Method－类的方法对象。通过这四个对象我们可以粗略的看到一个类的各个组 成部分。Java反射的作用：在Java运行时环境中，对于任意一个类，可以知道这个类有哪些属性和方法。对于任意一个对象，可以调用它的任意一个方法。这种动态获取类的信息以及动态调用对象的方法的功能来自于Java 语言的反射（Reflection）机制。Java 反射机制主要提供了以下功能在运行时判断任意一个对象所属的类。
在运行时构造任意一个类的对象。
在运行时判断任意一个类所具有的成员变量和方法。
在运行时调用任意一个对象的方法
反射的常用类和函数:Java反射机制的实现要借助于4个类：Class，Constructor，Field，Method；其中class代表的是类对象，Constructor－类的构造器对象，Field－类的属性对象，Method－类的方法对象，通过这四个对象我们可以粗略的看到一个类的各个组成部分。其中最核心的就是Class类，它是实现反射的基础，它包含的方法我们在第一部分已经进行了基本的阐述。应用反射时我们最关心的一般是一个类的构造器、属性和方法，下面我们主要介绍Class类中针对这三个元素的方法:1、得到构造器的方法 
Constructor getConstructor(Class[] params) -- 获得使用特殊的参数类型的公共构造函数， 
 
Constructor[] getConstructors() -- 获得类的所有公共构造函数 
 
Constructor getDeclaredConstructor(Class[] params) -- 获得使用特定参数类型的构造函数(与接入级别无关) 
 
Constructor[] getDeclaredConstructors() -- 获得类的所有构造函数(与接入级别无关) 
2、获得字段信息的方法Field getField(String name) -- 获得命名的公共字段 
 
Field[] getFields() -- 获得类的所有公共字段 
 
Field getDeclaredField(String name) -- 获得类声明的命名的字段 
 
Field[] getDeclaredFields() -- 获得类声明的所有字段 
3、获得方法信息的方法Method getMethod(String name, Class[] params) -- 使用特定的参数类型，获得命名的公共方法 
 
Method[] getMethods() -- 获得类的所有公共方法 
 
Method getDeclaredMethod(String name, Class[] params) -- 使用特写的参数类型，获得类声明的命名的方法 
 
Method[] getDeclaredMethods() -- 获得类声明的所有方法 
在程序开发中使用反射并结合属性文件，可以达到程序代码与配置文件相分离的目的如果我们想要得到对象的信息，一般需要“引入需要的‘包.类’的名称——通过new实例化——取得实例化对象”这样的过程。使用反射就可以变成“实例化对象——getClass()方法——得到完整的‘包.类’名称”这样的过程。正常方法是通过一个类创建对象，反射方法就是通过一个对象找到一个类的信息。
 * 
 * 
 * 
 * 
 * */