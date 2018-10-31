package enums;

public enum Color {
	 RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
	
    private String name;
    private int index;
    
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    
    /**
     * values() 获取一个枚举数组
     * 通过索引获取值
     */
    public static String getName(int index) {
    	for(Color color : Color.values()) {
    		if (color.index == index) {
				return color.name;
			}
    	}
    	return null;
    }
	
    /**
     * ordinal() 获取枚举放入的顺序
     * 通过名字获取放入的顺序
     */
    public static int getOrdinal(String name) {
    	for(Color color : Color.values()) {
    		if (color.name == name) {
				return color.ordinal();
			}
    	}
    	return -1;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
