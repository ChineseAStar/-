package com.trans;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import com.server.model.adjoin.*;
import java.io.*;

public class HowToXSLT {
	
	public boolean trans()
	{
		//���巵�ض���
		boolean b = false;
		
		try {
			//��ȡ���ݿ��ѯ����������ؽ���תΪSource����
			StreamSource source = new StreamSource(new ByteArrayInputStream(new XMLTest().selcetAll().getBytes()));
			//����������
		    TransformerFactory tFactory = TransformerFactory.newInstance();
		    //��������ʵ��
		    Transformer transformer = tFactory.newTransformer(new StreamSource("thetool.xslt"));
		    //���������
		    transformer.transform(source,new StreamResult(new OutputStreamWriter(new FileOutputStream("output.html"))));
		    //��ʾ����ɹ�
		    b = true;
		}
		catch (Exception e) {
		    e.printStackTrace( );
		}
		return b;
	}
}