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
      ����������Ƶ����ã�
              1�������룺.class-->.java
              2,ͨ��������Ʒ���java��������ԣ����������췽���ȣ�
             ����������������һЩ���±����Ǿ��忴��ôʵ����Щ���ܡ�
 �����������ȿ�һ��sunΪ�����ṩ����Щ��������е��ࣺ
java.lang.Class;                
java.lang.reflect.Constructor; java.lang.reflect.Field;        
java.lang.reflect.Method;
java.lang.reflect.Modifier;
      �ܶ෴���еķ��������ԵȲ������ǿ��Դ����ĸ����в�ѯ�������ľ仰Ҫѧ�Ų��ϵĲ�ѯAPI���ǲ���������õ���ʦ��
�ģ����幦��ʵ�֣�
1��������ƻ�ȡ�������ַ�������������ȡEmployee����
[java] view plain copy
//��һ�ַ�ʽ��  
Classc1 = Class.forName("Employee");  
//�ڶ��ַ�ʽ��  
//java��ÿ�����Ͷ���class ����.  
Classc2 = Employee.class;  
//�����ַ�ʽ��  
//java�������κ�һ��java������getClass ����  
Employeee = new Employee();  
Classc3 = e.getClass(); //c3������ʱ�� (e������ʱ����Employee)
2���������󣺻�ȡ���Ժ��������������Ķ�������newInstance��
Class c =Class.forName("Employee");  
//������Class ��������ʾ�����һ����ʵ��  
Objecto = c.newInstance(); //������Employee���޲������췽��.
3,��ȡ���ԣ���Ϊ���е����Ժ�ָ�������ԣ�
      a���ȿ���ȡ���е����Ե�д����
//��ȡ������  
        Class c = Class.forName("java.lang.Integer");  
          //��ȡ���е�����?  
        Field[] fs = c.getDeclaredFields();  
   
               //����ɱ䳤���ַ����������洢����  
        StringBuffer sb = new StringBuffer();  
        //ͨ��׷�ӵķ�������ÿ������ƴ�ӵ����ַ�����  
        //����ߵ�public����  
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");  
        //��ߵ�ÿһ������  
        for(Field field:fs){  
            sb.append("\t");//�ո�  
            sb.append(Modifier.toString(field.getModifiers())+" ");//������Ե����η�������public��static�ȵ�  
            sb.append(field.getType().getSimpleName() + " ");//���Ե����͵�����  
            sb.append(field.getName()+";\n");//���Ե�����+�س�  
        }  
        sb.append("}");  
        System.out.println(sb); 
b����ȡ�ض������ԣ��Ա��Ŵ�ͳ�ķ�����ѧϰ��
public static void main(String[] args) throws Exception{    
    /* 
*   User u = new User(); 
*   u.age = 12; //set 
*   System.out.println(u.age); //get 
    */  
/*
    //��ȡ��  
    Class c = Class.forName("User");  
    //��ȡid����  
    Field idF = c.getDeclaredField("id");  
    //ʵ��������ำ��o  
    Object o = c.newInstance();  
    //���Ʒ�װ  
    idF.setAccessible(true); //ʹ�÷�����ƿ��Դ��Ʒ�װ�ԣ�������java��������Բ���ȫ��  
    //��o�����id���Ը�ֵ"110"  
    idF.set(o, "110"); //set  
    //get  
    System.out.println(idF.get(o));  
} 
*/
/*
4����ȡ�������͹��췽����������ϸ������ֻ����һ�¹ؼ��֣�
�����ؼ���
����
getDeclaredMethods() ��ȡ���еķ���
getReturnType() ��÷����ķŻ�����
getParameterTypes()��÷����Ĵ����������
getDeclaredMethod("������",��������.class,����) ����ض��ķ���
���췽���ؼ���
����
getDeclaredConstructors() ��ȡ���еĹ��췽��
getDeclaredConstructor(��������.class,����) ��ȡ�ض��Ĺ��췽��
����͸��ӿ�
����
getSuperclass() ��ȡĳ��ĸ���
getInterfaces() ��ȡĳ��ʵ�ֵĽӿ�



���ߣ�������
���ӣ�https://www.zhihu.com/question/24304289/answer/76541818
��Դ��֪��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������

Java�ķ�����Ƶ�ʵ��Ҫ������4���ࣺclass��Constructor��Field��Method;
����class�����ʱ��� ��Constructor����Ĺ���������Field��������Զ���Method����ķ�������ͨ�����ĸ��������ǿ��Դ��ԵĿ���һ����ĸ����� �ɲ��֡�Java��������ã���Java����ʱ�����У���������һ���࣬����֪�����������Щ���Ժͷ�������������һ�����󣬿��Ե�����������һ�����������ֶ�̬��ȡ�����Ϣ�Լ���̬���ö���ķ����Ĺ���������Java ���Եķ��䣨Reflection�����ơ�Java ���������Ҫ�ṩ�����¹���������ʱ�ж�����һ�������������ࡣ
������ʱ��������һ����Ķ���
������ʱ�ж�����һ���������еĳ�Ա�����ͷ�����
������ʱ��������һ������ķ���
����ĳ�����ͺ���:Java������Ƶ�ʵ��Ҫ������4���ࣺClass��Constructor��Field��Method������class������������Constructor����Ĺ���������Field��������Զ���Method����ķ�������ͨ�����ĸ��������ǿ��Դ��ԵĿ���һ����ĸ�����ɲ��֡���������ĵľ���Class�࣬����ʵ�ַ���Ļ������������ķ��������ڵ�һ�����Ѿ������˻����Ĳ�����Ӧ�÷���ʱ��������ĵ�һ����һ����Ĺ����������Ժͷ���������������Ҫ����Class�������������Ԫ�صķ���:1���õ��������ķ��� 
Constructor getConstructor(Class[] params) -- ���ʹ������Ĳ������͵Ĺ������캯���� 
 
Constructor[] getConstructors() -- ���������й������캯�� 
 
Constructor getDeclaredConstructor(Class[] params) -- ���ʹ���ض��������͵Ĺ��캯��(����뼶���޹�) 
 
Constructor[] getDeclaredConstructors() -- ���������й��캯��(����뼶���޹�) 
2������ֶ���Ϣ�ķ���Field getField(String name) -- ��������Ĺ����ֶ� 
 
Field[] getFields() -- ���������й����ֶ� 
 
Field getDeclaredField(String name) -- ������������������ֶ� 
 
Field[] getDeclaredFields() -- ����������������ֶ� 
3����÷�����Ϣ�ķ���Method getMethod(String name, Class[] params) -- ʹ���ض��Ĳ������ͣ���������Ĺ������� 
 
Method[] getMethods() -- ���������й������� 
 
Method getDeclaredMethod(String name, Class[] params) -- ʹ����д�Ĳ������ͣ�����������������ķ��� 
 
Method[] getDeclaredMethods() -- ��������������з��� 
�ڳ��򿪷���ʹ�÷��䲢��������ļ������Դﵽ��������������ļ�������Ŀ�����������Ҫ�õ��������Ϣ��һ����Ҫ��������Ҫ�ġ���.�࡯�����ơ���ͨ��newʵ��������ȡ��ʵ�������������Ĺ��̡�ʹ�÷���Ϳ��Ա�ɡ�ʵ�������󡪡�getClass()���������õ������ġ���.�࡯���ơ������Ĺ��̡�����������ͨ��һ���ഴ�����󣬷��䷽������ͨ��һ�������ҵ�һ�������Ϣ��
 * 
 * 
 * 
 * 
 * */