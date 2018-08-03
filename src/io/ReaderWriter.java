package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ReaderWriter {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*InputStreamExp01();
		ReaderExp01();*/
		BufReaderExp02();
	}

	/*
	 * inputstream
	 * outputstream
	 * 字节流读写
	 * */
	public static void InputStreamExp01() throws IOException{
		
		InputStream	in=new FileInputStream("d:/新建文本文档 (2).txt");
		OutputStream out=new FileOutputStream("d:/test.txt");
		/*byte表示字节*/
		byte[] buf=new byte[1024];
		int b=0;
		while( (b=in.read(buf))!=-1 ){
			System.out.println(new String(buf,0,b));
			out.write(buf,0,b);
		}
		out.flush();
		out.close();
	}
	
/*	public void BufInputStreamExp01(){
		BufferedInputStream bufin=new FileInputStream("d:/新建文本文档 (2).txt");
		
	}*/
/*
注意事项：

* 写入文件后必须要用flush()刷新。
* 用完流后记得要关闭流
* 使用流对象要抛出IO异常
* 定义文件路径时，可以用“/”或者“\\”。
* 在创建一个文件时，如果目录下有同名文件将被覆盖。
* 在读取文件时，必须保证该文件已存在，否则出异常
* */
	public static void ReaderExp01() throws IOException{
		Reader reader=new FileReader("d:/新建文本文档 (2).txt");
		Writer writer=new FileWriter("d:/testout.txt");

		/*char 表示字符*/
		char[] buf=new char[1024];
		int b=0;
		
		while( ( b=reader.read(buf) )!=-1 ){
			writer.write(buf,0,b);
		}
		writer.flush();
		writer.close();
	}
/*
* 缓冲区的出现时为了提高流的操作效率而出现的.
* 需要被提高效率的流作为参数传递给缓冲区的构造函数
* 在缓冲区中封装了一个数组，存入数据后一次取出
 * */
	public static void BufReaderExp01() throws IOException{
		Reader reader=new FileReader("d:/新建文本文档 (2).txt");
		Writer writer=new FileWriter("d:/buftestout.txt");
		BufferedReader bufReader=new BufferedReader(reader);
		BufferedWriter bufWriter=new BufferedWriter(writer);
		/*char 表示字符*/
		char[] buf=new char[1024];
		int b=0;
		
		while( ( b=bufReader.read(buf) )!=-1 ){
//			System.out.println(new String(buf,0,b));
			bufWriter.write(buf,0,b);
		}

		bufWriter.flush();
		
		writer.close();
	}
/*
读取流缓冲区提供了一个一次读一行的方法readline，方便对文本数据的获取。
readline()只返回回车符前面的字符，不返回回车符。如果是复制的话，必须加入newLine()，写入回车符
newLine()是java提供的多平台换行符写入方法。
 * */
	/*使用readLine读取*/
	public static void BufReaderExp02() throws IOException{
		Reader reader=new FileReader("d:/新建文本文档 (2).txt");
		Writer writer=new FileWriter("d:/buftestout02.txt");
		BufferedReader bufReader=new BufferedReader(reader);
		BufferedWriter bufWriter=new BufferedWriter(writer);
		 String tmp= null;
		while ( (tmp= bufReader.readLine()) != null ) {
			bufWriter.write(tmp);
			bufWriter.newLine();
		}
		bufWriter.flush();
		bufWriter.close();
		
		writer.close();
	}
	
}
