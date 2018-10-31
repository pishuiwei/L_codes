package io;

import java.io.File;

import base.P;

/**
 * 文件夹的操作(创建、删除、重命名)
 * @author PP
 *
 */
public class FolderDemo {
	
	public static void main(String[] args) {
		createFolder();
	}
	
	/**
	 * 获取文件夹里的所有文件、文件夹
	 * @param dir
	 * @param tab
	 */
	public static void printFiles(File dir,int tab){
		if (dir.exists()) {
			File next[] = dir.listFiles();
			for (int i = 0; i < next.length; i++){
					for (int j = 0; j < next.length; j++) {
						P.print("|----");
					}
				P.println(next[i].getName());
				if (next[i].isDirectory()) {
					printFiles(next[i],tab+1);
				}
			}
		}
	}
	
	/**
	 * 创建文件夹
	 */
	public static void createFolder(){
		File file = new File("folder");
		if (file.mkdirs()) {
			P.println("文件夹创建完成");
		}else {
			if (file.exists()) {
				P.println("文件夹存在");
			}else {
				P.println("文件创建失败");
			}
		}
	}

	/**
	 * 重命名文件夹
	 */
	public static void renameFolder(){
		File file = new File("folder");
		File f = new File("pp");
		if (file.renameTo(f)) {
			P.println("重命名成功");
		}else {
			P.println("重命名失败");
		}
	}

	/**
	 * 删除文件
	 */
	public static void deleteFolder(){
		File file = new File("folder");
		if (file.delete()) {
			P.println("成功");
		}else{
			P.println("失败");
		}
	}
}
