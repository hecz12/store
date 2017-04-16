package com.store.utils;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 利用反射实现解隅和
 * @author 何长治
 *
 */
public class BeanFactory {
	public static Object getBean(String id)
	{
		Object obj = null;
		try {
			//获取xml文档对象
			Document doc = new SAXReader().read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
			//获取指定id的元素
			Element element = (Element) doc.selectSingleNode("//bean[@id='"+id+"']");
			//获取对应class属性的值
			String value = element.attributeValue("class");
			System.out.println(value);
			//利用反射得到此对象
			obj = Class.forName(value).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
