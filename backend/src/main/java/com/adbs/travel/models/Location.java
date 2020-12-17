package com.adbs.travel.models;

public class Location {
	
	private int id;
	private String name;
	private String imageUrl;
	private double latitude;
	private double longitude;
	private String country;
	private String city;
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", country=" + country + ", city=" + city + "]";
	}
	public Location(int id, String name, String imageUrl, double latitude, double longitude, String country,
			String city) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.city = city;
	}
	public Location() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
