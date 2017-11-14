package com.trans;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import com.server.model.adjoin.*;
import java.io.*;

public class HowToXSLT {
	
	public boolean trans()
	{
		//定义返回对象
		boolean b = false;
		
		try {
			//获取数据库查询结果，并返回将其转为Source对象
			StreamSource source = new StreamSource(new ByteArrayInputStream(new XMLTest().selcetAll().getBytes()));
			//创建翻译器
		    TransformerFactory tFactory = TransformerFactory.newInstance();
		    //创建翻译实例
		    Transformer transformer = tFactory.newTransformer(new StreamSource("thetool.xslt"));
		    //输出翻译结果
		    transformer.transform(source,new StreamResult(new OutputStreamWriter(new FileOutputStream("output.html"))));
		    //表示翻译成功
		    b = true;
		}
		catch (Exception e) {
		    e.printStackTrace( );
		}
		return b;
	}
}