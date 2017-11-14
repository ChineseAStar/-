package com.server.model.adjoin;

import java.sql.*;

import com.server.model.core.*;

public class XMLTest {
	
	public String selcetAll()
	{
		//���巵�ض���
		String b = "";
		
		//�������ݿ����ӵ������
		SqlHelper sp = null;
		ResultSet rs = null;
		
		try{
			
			//����sql���
			String sql = "SELECT ("
					+ "SELECT [first],[middle],[last] FROM contacts i "
					+ "WHERE [i].[first] = [o].[first] FOR XML PATH('name'), TYPE),"
					+ "(SELECT [address],[latitude],[longitude] FROM contacts i "
					+ "WHERE [i].[first] = [o].[first] FOR XML PATH('location'), TYPE),"
					+ "[phone],[description] "
					+ "FROM contacts o "
					+ "FOR XML PATH('contact'), ROOT('contacts');";
			//ʵ�������ݿ����Ӷ���
			sp = new SqlHelper();
			//���ؽ����
			rs = sp.query(sql);
			//ȡ�ý��
			if(rs.next())
				b = rs.getString(1);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				sp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
}
