package enums;

import java.util.*;
import java.util.Map.Entry;

public class EnumMapDemo {
	
	public static void main(String[] args) {
        EnumMap<Color, String> weekMap = new EnumMap<Color, String>(Color.class);
        weekMap.put(Color.BLANK, "白色");
        weekMap.put(Color.GREEN, "绿色");
        // ... ...
        for (Iterator<Entry<Color, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Entry<Color, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }		
	}

}
