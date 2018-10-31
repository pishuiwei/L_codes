package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import base.P;

/**
 * InputStreamReader 可以把InputStream转换成Reader OutputStreamWriter
 * OutputStreamWriter 可以吧OutStream转化为Writer
 * 
 * @author PP 2017-09-3 12:06
 * 
 */
public class FileDemo {
	public static void main(String[] args) throws IOException {
		// createFile();
		File file = new File("./");
		System.out.println(file.getCanonicalPath());
		// file.createNewFile();
		String[] files = file.list();
		System.out.println(Arrays.toString(files));
	}

	/**
	 * File类常用的方法
	 */
	public static void readFileProperty() {
		File file = new File("text.txt");
		// 判断文件是否存在
		P.println("判断文件是否存在:" + file.exists());
		// 获取文件名称
		P.println("读取文件名称:" + file.getName());
		// 获取文件路径(相对)
		P.println("获取文件路径:" + file.getPath());
		// 获取文件绝对路径
		P.println("获取文件绝对路径:" + file.getAbsolutePath());
		// 获取文件父级路劲
		P.println("获取文件父级路径:" + new File(file.getAbsolutePath()).getParent());
		// 获取文件大小
		P.println("获取文件大小:" + (float) file.length() / 1000 + "kb");
		// 判断文件是否被隐藏
		P.println("判断文件是否被隐藏:" + file.isHidden());
		// 判断文件是否可读
		P.println("判断文件是否可读:" + file.canRead());
		// 判断文件是否可写
		P.println("判断文件是否可写:" + file.canWrite());
		// 判断是否是文件夹
		P.println("判断是否是文件夹:" + file.isDirectory());
	}

	/**
	 * 设置文件属性
	 */
	public static void setFileProperty() {
		File file = new File("text.txt");
		if (file.exists()) {
			file.setWritable(false);
			file.setReadable(true);
			file.setReadOnly();
		}
	}

	/**
	 * 创建文件
	 */
	public static void createFile() {
		File file = new File("hello.txt");// 相对路径不要以任何非字母开头
		if (file.exists()) {
			P.println(file.isFile());

			P.println(file.isDirectory());
		} else {
			try {
				file.createNewFile();
				P.println("文件创建成功");
			} catch (IOException e) {
				P.println("无法创建文件");
			}
		}
	}

	/**
	 * 删除文件
	 */
	public static void delete() {
		File file = new File("hello.text");// 相对路径不要以任何非字母开头
		if (file.exists()) {
			file.delete();
			P.println("文件删除成功");
		} else {
			P.println("文件不存在");
		}
	}

	/**
	 * 修改文件名
	 */
	public static void rename() {
		File file = new File("hello.txt");// 相对路径不要以任何非字母开头
		if (file.exists()) {
			File file2 = new File("pp.txt");
			file.renameTo(file2);
			P.println("文件修改成功");
		} else {
			P.println("文件不存在");
		}
	}

	/**
	 * 读取文件类容
	 */
	public static void readFiel() {
		File file = new File("text.txt");
		if (file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);

				String line;
				while ((line = br.readLine()) != null) {
					P.println(line);
				}
				br.close();
				isr.close();
				fis.close();
			} catch (FileNotFoundException e) {
				P.println(e.getMessage());
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				P.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写入文件内容
	 */
	public static void writeFile() {
		try {
			File file = new File("text.txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write("oy");

			bw.close();
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
