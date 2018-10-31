package xml;

/**
 * <p>平台无关性,语言无关性,系统无关性
 * <p>基本的解析方式有两种,一种叫SAX，另一种叫DOM
 * <p>SAX是基于事件流的解析,DOM是基于XML文档树结构的解析
 * 
 * <p>定义XML文档建立与解析的接口
 * @author pp
 * 
 *<p>static 默认为final
 */
public abstract class XmlDocument {
	
	/** 
	* 建立XML文档 
	* @param fileName 文件全路径名称 
	*/ 
	public static void createXml(String fileName){}; 
	
	/** 
	* 解析XML文档 
	* @param fileName 文件全路径名称 
	*/ 
	public static void parserXml(String fileName){}; 
	
}






