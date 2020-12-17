package com.adbs.travel.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.adbs.travel.exceptions.DatabaseException;



public class Database {
	
	public static Connection getConnection() throws DatabaseException{
		Connection connection = null;
		String url = readProperty("connectionString");
		String user = readProperty("user");
		String password = readProperty("password");
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
			 throw new DatabaseException("Could'nt connect with the Database");
		}
		return connection;
	}
	
	
	public static String readProperty(String property){
		Properties properties = new Properties();
		File file = new File("E:\\CapacitacionCMC\\WorkspaceCMC\\travel-locations\\connection.properties");
		try {
			properties.load(new FileReader(file));	
			return properties.getProperty(property) != null ? properties.getProperty(property) : null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
