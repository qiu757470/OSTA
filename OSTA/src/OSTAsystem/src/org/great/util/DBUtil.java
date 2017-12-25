package org.great.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties  properties = new Properties();
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String userpwd = null;
	public static String teachname=null;
	public static String teachpwd=null;
	public static String xiamen=null;
	
	static{
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("jdbc.dirver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			userpwd = properties.getProperty("jdbc.userpwd");
			teachname = properties.getProperty("teachname");
			teachpwd = properties.getProperty("teachpwd");
			xiamen = properties.getProperty("xiamen");
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}

	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection(url,username,userpwd);
	}

	public static void closeConn(Connection conn,ResultSet res,PreparedStatement pStmt){

		if(res!=null){
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(pStmt!=null){
			try {
				pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}	
	}
}
