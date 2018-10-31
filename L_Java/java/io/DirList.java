package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 
 * @author PP
 * 2017-09-3 16:56
 *
 */
public class DirList {
	
	public void dirListName(String[] args) {
		File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		}else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}

@SuppressWarnings("static-access")
class DirFilter implements FilenameFilter {
	private  Pattern pattern;
	public DirFilter(String regex){
		pattern = pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}