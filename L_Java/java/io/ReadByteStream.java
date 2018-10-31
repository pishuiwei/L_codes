package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import base.P;

public class ReadByteStream {
	public static void main(String[] args) {
		ReadByteFile();
	}
	
	/**
	 * 写入文件
	 */
	public static void writeByteFile(){
		try {
			FileOutputStream fos = new FileOutputStream("newFile.txt");
			String outString = "成功还是失败！！";
			byte output[] = outString.getBytes("UTF-8");
			fos.write(output);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 读取文件
	 */
	public static void ReadByteFile(){
		try {
			//读取文件
			FileInputStream fis = new FileInputStream("text.txt");
			byte input[] = new byte[512];
			int l;
			while((l=fis.read(input))!=-1){
				String inputString = new String(input,0,l);
				P.println("s"+inputString);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 复制文件
	 */
	public static void copyFile(){
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			FileOutputStream fos = new FileOutputStream("newText.txt");
			
			byte[] input = new byte[512];
			int l;
			while((l=fis.read(input))!=-1){
				fos.write(input,0,l);
			}
			fis.close();
			fos.close();
			
			P.println("done!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
