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
		System.out.println("\n ������a��");
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
		File f=new File("D:\\tmp1\\�½��ı��ĵ�.txt");
        try{  
        	
            f.createNewFile();  //���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ���  
            System.out.println("�÷�����С"+f.getTotalSpace()/(1024*1024*1024)+"G"); //�����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�  
            f.mkdirs();  //�����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��  
//	            f.delete(); //  ɾ���˳���·������ʾ���ļ���Ŀ¼  
           System.out.println("�ļ���  "+f.getName());  //  �����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�  
           System.out.println("�ļ���Ŀ¼�ַ��� "+f.getParent());// ���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻� null��
           
            FileReader fis=new FileReader(f);
            int read;  
            //read=fis.read();  
            byte b[]=new byte[1024];  
            //��ȡ�ļ��������ֽ�����b�����ض�ȡ�����ַ���������read,Ĭ��ÿ�ν�b����װ��  
            
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
