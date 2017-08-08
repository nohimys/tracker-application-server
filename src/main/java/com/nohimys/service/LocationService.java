package com.nohimys.service;

import org.springframework.stereotype.Service;

import com.nohimys.model.GpsLocation;
import com.nohimys.model.derivedResponses.GpsLocationWithUsername;
import com.nohimys.model.derivedResponses.LocationResponse;

@Service
public class LocationService {

	public boolean updateLocation(GpsLocationWithUsername gpsLocationWithUsername) {
		System.out.println(gpsLocationWithUsername.getUsername());
		System.out.println(gpsLocationWithUsername.getGpsLocation().getLatitude());
		System.out.println(gpsLocationWithUsername.getGpsLocation().getLongitude());
		return true;
	}
	
	public LocationResponse getCurrentLocation(String username) {
		LocationResponse locationResponse = new LocationResponse();
		if (username.equals("nohim")) {
			locationResponse.setFriendlyName("Nohim Sandeepa");
			locationResponse.setReportedTime("2017:08:08 15:56");
			locationResponse.setConfigurationUpdated(true);
			locationResponse.setGpsLocation(new GpsLocation("75.222","75.222"));
		}
		return locationResponse;
	}
}
