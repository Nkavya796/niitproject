package com.niit.SkillMappingBackEnd.Utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnect {
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		

		InputStream in = new FileInputStream("D:\\NIIT\\Java Term 2\\jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
	public static Connection connect()
	{
		Connection con = null;

		try {

			Properties prop = loadPropertiesFile();

			
			String url = prop.getProperty("SQLJDBC.url");
			String username = prop.getProperty("SQLJDBC.username");
			String password = prop.getProperty("SQLJDBC.password");

			//Class.forName(driverClass);

			con = DriverManager.getConnection(url, username, password);

			if (con != null) {
				System.out.println("connection created successfully using properties file");
			}

			else {
				System.out.println(" unable to create connection");
			}

		}catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			
		}
		return con;
	}

}
