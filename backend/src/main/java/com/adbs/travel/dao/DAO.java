package com.adbs.travel.dao;

import java.sql.Connection;

import com.adbs.travel.db.Database;
import com.adbs.travel.exceptions.DatabaseException;



public class DAO {
	Connection connection;
	
	public void openConnection() throws DatabaseException{
		connection = Database.getConnection();
	}
	
	public void closeConnection() throws DatabaseException{
		try {
			if(connection!=null){
				connection.close();
				System.out.println("Connection closed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseException("The connection couldn't be closed.");
		}
	}
}
