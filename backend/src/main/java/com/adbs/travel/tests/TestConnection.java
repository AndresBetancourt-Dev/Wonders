package com.adbs.travel.tests;

import java.sql.Connection;

import com.adbs.travel.db.Database;
import com.adbs.travel.exceptions.DatabaseException;

public class TestConnection {

	public static void main(String[] args) {
		try {
			Connection connection = Database.getConnection();
			System.out.println(connection);
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

}
