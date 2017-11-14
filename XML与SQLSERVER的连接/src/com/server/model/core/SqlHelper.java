package com.server.model.core;

import java.sql.*;

public class SqlHelper {


	//定义需要的对象
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection ct = null;
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=XML";
	String user = "sa";
	String passwd = "1234";
	
	//构造函数,初始化ct
	public SqlHelper()
	{
		try {
			//加载驱动
			Class.forName(driver);
			ct = DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//关闭资源
	public void close()
	{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//对数据库的查询
	public ResultSet query(String sql)
	{
		try {
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
