package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadByBufferedByteStream {
	public static void main(String[] args) {
		witr();
	}

	/**
	 * 读取文件
	 */
	public static byte[] read(){
		byte[] input = null;
		try {
			FileInputStream fis = new FileInputStream("text.txt");//此为字节流，InputStreamRead为字符流,此为字节流
			BufferedInputStream buf = new BufferedInputStream(fis);//BufferedRead为字符缓冲流,此为字节流
			input = new byte[512];
			while (buf.read(input)!=-1) {
				
			}
			buf.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	/**
	 * 复制文件
	 */
	public static void witr(){
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream  fos = new FileOutputStream("pp.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] input = new byte[512];
			int l;
			while ((l=bis.read(input))!=-1) {
				bos.write(input,0,l);
			}
			bos.close();
			fos.close();
			bis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
