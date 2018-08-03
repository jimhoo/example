package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.Buffer;



public class FileExample {
	public static void main(String[] args) throws IOException{
		createFile();
		copyFile();
		inputStreamReaderTest();
	}
	
	public static void inputStreamReaderTest() throws IOException{
		String inFile="d:\\tmp1\\example.rar";
		String outFile="d:\\tmp1\\outfile22.txt";
		OutputStream ops=new FileOutputStream( new File(outFile));
		System.out.println("\n 请输入a：");
		InputStreamReader inr=new InputStreamReader(System.in);
		OutputStreamWriter osw=new OutputStreamWriter(ops);
		BufferedReader br=new BufferedReader(inr);
		BufferedWriter bw=new BufferedWriter(osw);
		String buffer=null;
		while( (buffer=br.readLine()) !=null ){
			
			bw.write(buffer);
		}
		bw.flush();
		if(inr!=null){
			inr.close();
		}
		if(osw!=null){
			osw.close();
		}
		
		
	}
	
	public static void copyFile() throws IOException{
		String inFile="d:\\tmp1\\example.rar";
		String outFile="d:\\tmp1\\example1.rar";
		FileInputStream fis=new FileInputStream(new File(inFile));
		FileOutputStream fos=new FileOutputStream(new File(outFile));
		BufferedInputStream bis=new BufferedInputStream(fis);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		byte[] buf=new byte[1024];
		
		int length=0;
		while(  ( length=bis.read(buf) ) !=-1 ){
			bos.write(buf,0,length);
		}
		bos.flush();
		if(bos!=null){
		fos.close();}
		if(bis!=null){
		fis.close();}
		
	}
	
	public static void createFile() throws IOException{
		File f=new File("D:\\tmp1\\新建文本文档.txt");
        try{  
        	
            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。  
            System.out.println("该分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G"); //返回由此抽象路径名表示的文件或目录的名称。  
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。  
//	            f.delete(); //  删除此抽象路径名表示的文件或目录  
           System.out.println("文件名  "+f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。  
           System.out.println("文件父目录字符串 "+f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
           
            FileReader fis=new FileReader(f);
            int read;  
            //read=fis.read();  
            byte b[]=new byte[1024];  
            //读取文件，存入字节数组b，返回读取到的字符数，存入read,默认每次将b数组装满  
            
/*            read=fis.read();
            while(read!=-1)  
            {   
                System.out.print((char) read);  
                read=fis.read(); 
            }  */

            char[] bb=new char[1024];
            while( ( read=fis.read(bb) )!=-1 ){
            	System.out.print(new String(bb,0,read));
            }

            
            fis.close();  
            
        }catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
}
