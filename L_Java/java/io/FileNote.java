package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 
 * @author PW 2018/01/07
 *
 */
@SuppressWarnings("all")
public class FileNote {
	public final static String PATH = "C:/Users/Administrator/Desktop/new.txt"; 
	
	public static void main(String[] args) throws IOException {
//		char c = '\uFFFE';
//		System.out.println("1:"+c);
//		System.out.println("Hex:" + Integer.toHexString(-79));
//		System.out.println("10进制:" + Integer.parseInt("FFFF", 16));
//		System.out.println("");
//		
//		System.out.println(URLDecoder.decode("%77%4F%1A","UTF-8"));
//		
		PushbackInputStream pis = new PushbackInputStream(new FileInputStream(PATH));
		int tmp = 0;
		int count = 0;
		
		byte[] array = new byte[3];
//		
		while((count = pis.read(array))!=-1) {
			tmp++;
		}
		
		System.out.println((char)array[0]);
		System.out.println((char)array[1]);
		System.out.println((char)array[2]);
		pis.close();
		System.out.println("结束: " + tmp);
	}
	
	
	

/*	public static void main(String[] args) throws IOException {
		//InputStream 
		 FileInputStream fileInputStream = new FileInputStream("C:/Users/Administrator/Desktop/test.xlsx");
		
		FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/IOs.xlsx");
		int result;
		int i=0;
		while((result = fileInputStream.read()) != -1){
			fileOutputStream.write(result);
			i++;
		}
		fileInputStream.close();
		System.out.println(i);
		System.out.println("结束");
		
	}*/
	
}






