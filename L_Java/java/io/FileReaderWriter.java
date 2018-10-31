package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import base.P;

public class FileReaderWriter {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:/Users/Administrator/Desktop/test.txt");
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter("C:/Users/Administrator/Desktop/newTest.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			String line;
			while ((line = br.readLine())!=null) {
				pw.write(line+"\n");
			}
			pw.close();
			fw.close();
			br.close();
			fr.close();
			P.print("done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
