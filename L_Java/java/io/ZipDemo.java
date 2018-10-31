package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import base.P;

public class ZipDemo {
	
	public static void main(String[] args) throws IOException {
//		压缩文件
//		ZipDemo zipDemo = new ZipDemo();
//		zipDemo.zip("E:/hello.zip", new File("hello.txt"));
//		P.println("压缩完成！");
		
		ZipInputStream zin;
		try {
			zin = new ZipInputStream(new FileInputStream("E:/hello.zip"));
			ZipEntry entry = zin.getNextEntry();
			while (((entry=zin.getNextEntry())!=null)&&!entry.isDirectory()) {
				File file = new File("e:\\"+entry.getName());
				P.println(file);
				if (!file.exists()) {
					file.mkdirs();
					file.createNewFile();
				}
				zin.closeEntry();
				P.println(entry.getName()+"解压成功");
			}
			zin.close();
		} catch (Exception e) {
			e.printStackTrace();
			P.println("解压失败");
		}
	}
	
	private void zip(String zipFileName,File inputFile) throws IOException{
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile,"");
		P.print("压缩中...");
		out.close();
	}
	
	private void zip(ZipOutputStream out,File f,String base) throws IOException {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			out.putNextEntry(new ZipEntry(base+"/"));
			base = base.length() == 0 ? "" :base+"/";
			for (int i = 0; i < files.length; i++) {
				zip(out, files[i],base+files[i]);
			}
		}else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			P.println(base);
			while((b = in.read())!=-1){
				out.write(b);
			}
			in.close();
		}
		

	}

}
