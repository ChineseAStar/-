package com.server.model.adjoin;

import java.sql.*;

import com.server.model.core.*;

public class XMLTest {
	
	public String selcetAll()
	{
		//定义返回对象
		String b = "";
		
		//定义数据库连接的相关类
		SqlHelper sp = null;
		ResultSet rs = null;
		
		try{
			
			//定义sql语句
			String sql = "SELECT ("
					+ "SELECT [first],[middle],[last] FROM contacts i "
					+ "WHERE [i].[first] = [o].[first] FOR XML PATH('name'), TYPE),"
					+ "(SELECT [address],[latitude],[longitude] FROM contacts i "
					+ "WHERE [i].[first] = [o].[first] FOR XML PATH('location'), TYPE),"
					+ "[phone],[description] "
					+ "FROM contacts o "
					+ "FOR XML PATH('contact'), ROOT('contacts');";
			//实例化数据库连接对象
			sp = new SqlHelper();
			//返回结果集
			rs = sp.query(sql);
			//取得结果
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
