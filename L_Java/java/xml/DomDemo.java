package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <p>
 * DOM生成与解析XML文档
 * <p>
 * 优点：整个文档树在内存中，便于操作；支持删除、修改、重新排列等多种功能
 * <p>
 * 缺点：将整个文档调入内存（包括无用的节点），浪费时间和空间； 使用场合：一旦解析了文档还需多次访问这些数据；硬件资源充足（内存、CPU）。
 * 
 * @author pp
 */
public class DomDemo extends XmlDocument {

	private static Document document;

	static {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createXml(String fileName) {
		Element root = document.createElement("employees");
		document.appendChild(root);

		/* 子节点(可以包含多个) */
		Element employee = document.createElement("employee");

		Element name = document.createElement("name");
		name.appendChild(document.createTextNode("丁宏亮"));
		employee.appendChild(name);
		Element sex = document.createElement("sex");
		sex.appendChild(document.createTextNode("m"));
		employee.appendChild(sex);
		Element age = document.createElement("age");
		age.appendChild(document.createTextNode("30"));
		employee.appendChild(age);

		/* 把字节点放入根节点 */
		root.appendChild(employee);

		TransformerFactory tf = TransformerFactory.newInstance();

		try {
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(document);
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
			System.out.println("生成XML文件成功!");
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void parserXml(String fileName) {
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(fileName);
			/*
			 * 第一个for为了获取root(根)元素,第二个才开始获取元素 与Dom4j相比多了此步骤
			 */
			NodeList employees = document.getChildNodes();
			for (int i = 0; i < employees.getLength(); i++) {
				Node employee = employees.item(i);
				NodeList employeeInfo = employee.getChildNodes();
				for (int j = 0; j < employeeInfo.getLength(); j++) {
					Node node = employeeInfo.item(j);
					NodeList employeeMeta = node.getChildNodes();
					for (int k = 0; k < employeeMeta.getLength(); k++) {
						Node node2 = employeeMeta.item(k);
						if (node2 instanceof Element) {
							// System.out.println(node2.getNodeName()+ ":" +
							// node2.getTextContent());
						}
						if (k == employeeMeta.getLength() - 1) {
							System.out.println("-------------");
						}
					}
				}
			}
			System.out.println("解析完毕");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}