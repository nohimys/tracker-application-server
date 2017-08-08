package com.nohimys.model;

public class GpsLocation {
	private String latitude;
	private String longitude;
	
	public GpsLocation() {		
	}
	
	public GpsLocation(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
