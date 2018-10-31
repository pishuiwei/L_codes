package util;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * XML 文件解析类
 * 
 * @author PW 2018/03/29
 *
 */
public class XMLUtil {
	
	public static Object getBean() {
		
		try {
			// 创建DOM文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/designMode/util/config.xml"));
			
			// 获取包含类名的文本结点
			NodeList n1 = doc.getElementsByTagName("className");
			Node classNode = n1.item(0).getFirstChild();
			String className = classNode.getNodeValue();
			
			// 通过类名生成实例对象并将其返回
			Class<?> c = Class.forName(className);
			Object obj = c.newInstance();
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getName() {
		
		try {
			// 创建DOM文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc = builder.parse(new File("src/main/designMode/util/config.xml"));
			
			// 获取包含类名的文本结点
			NodeList n1 = doc.getElementsByTagName("className");
			Node classNode = n1.item(0).getFirstChild();
			String className = classNode.getNodeValue();
			
			return className;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
