package com.adbs.travel.tests;

import com.adbs.travel.db.Database;

public class TestProperties {
		public static void main(String[] args) {
			String url = Database.readProperty("connectionString");
			String user = Database.readProperty("user");
			String password = Database.readProperty("password");
			
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
		}
}
