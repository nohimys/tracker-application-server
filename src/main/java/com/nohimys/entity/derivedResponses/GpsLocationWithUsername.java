package com.nohimys.entity.derivedResponses;

import com.nohimys.entity.GpsLocation;

public class GpsLocationWithUsername {
	private String username;
	private GpsLocation gpsLocation;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GpsLocation getGpsLocation() {
		return gpsLocation;
	}
	public void setGpsLocation(GpsLocation gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	
	
}
