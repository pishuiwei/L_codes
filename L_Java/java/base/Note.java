package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@SuppressWarnings("all")
public class Note {
	
	public static void main(String[] args) throws Exception {
		String path = "C:/Users/Administrator/Desktop/newTest.txt";
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		byte[] bs = new byte[512];
		int s = inputStream.read(bs);
		System.out.println((char)s); 
		
//		FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Administrator/Desktop/newtest.xlsx");
//		fileOutputStream.write(s);
	
	}

}
