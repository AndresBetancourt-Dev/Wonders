package com.adbs.travel.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adbs.travel.exceptions.DatabaseException;
import com.adbs.travel.models.Location;


public class LocationDAO extends DAO {
		
	public List<Location> getLocations() throws DatabaseException{
		PreparedStatement statement = null;
		List<Location> list = new ArrayList<Location>();
		try {
			openConnection();
			String sql = "SELECT * FROM locations";
			statement = connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			 while(result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				String imageUrl = result.getString("imageUrl") ;
				double latitude = result.getDouble("latitude");
				double longitude = result.getDouble("longitude");
				String country = result.getString("country");
				String city = result.getString("city");
				list.add(new Location(id, name, imageUrl, latitude, longitude, country, city));
		      }
			 closeConnection();
			 return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Couldn't get the locations");
		}
	}
	
	public void insertLocation(Location location) throws DatabaseException{
		PreparedStatement statement = null;
		try{
			openConnection();
			System.out.println("Inserting records into the table...");
		    statement = connection.prepareStatement("INSERT INTO locations(name,imageUrl,latitude,longitude,country,city) VALUES (?,?,?,?,?,?)");
		    statement.setString(1, location.getName());
		    statement.setString(2, location.getImageUrl());
		    statement.setDouble(3, location.getLatitude());
		    statement.setDouble(4, location.getLongitude());
		    statement.setString(5, location.getCountry());
		    statement.setString(6, location.getCity());
		    statement.executeUpdate();
		    closeConnection();
		}catch(SQLException e){
		      e.printStackTrace();
		      throw new DatabaseException("Couldn't get the locations");
		}catch(Exception e){
		      e.printStackTrace();
		}
	}
}
