package xml;

import java.io.File;   
import java.io.FileWriter;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.Iterator;   

import org.dom4j.Document;   
import org.dom4j.DocumentException;   
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;   
import org.dom4j.io.SAXReader;   
import org.dom4j.io.XMLWriter;   
/**  
 * <p>Dom4j 生成XML文档与解析XML文档  
 * <p>DOM4J 是一个非常非常优秀的Java XML API
 * @author pp
 */  
public class Dom4jDemo extends XmlDocument {   

	public static void createXml(String fileName){
		Document document = DocumentHelper.createDocument();   
		Element employees=document.addElement("employees");   
		Element employee=employees.addElement("employee");   
		Element name= employee.addElement("name");   
		name.setText("pp");   
		Element sex=employee.addElement("sex");   
		sex.setText("man");   
		Element age=employee.addElement("age");   
		age.setText("18");   
		try {   
			Writer fileWriter=new FileWriter(fileName);   
			XMLWriter xmlWriter=new XMLWriter(fileWriter); 
			xmlWriter.write(document);   
			xmlWriter.close();   
		} catch (IOException e) {   
			System.out.println(e.getMessage());   
		}   
	}   

	public static void parserXml(String fileName) {
		File inputXml=new File(fileName);   
		SAXReader saxReader = new SAXReader();   
		try {
			Document document = saxReader.read(inputXml);   
			Element employees=document.getRootElement();
			for(Iterator<?> i = employees.elementIterator(); i.hasNext();){   
				Element employee = (Element) i.next();   
				for(Iterator<?> j = employee.elementIterator(); j.hasNext();){   
					Element node=(Element) j.next();   
					System.out.println(node.getName()+":"+node.getText());
				}   
			}   
		} catch(DocumentException e) {   
			System.out.println(e.getMessage());   
		}   
	}   
}   