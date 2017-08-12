package com.nohimys.service;

import java.text.ParseException;

import com.nohimys.model.derivedResponses.GpsLocationWithUsernameAndTime;
import com.nohimys.model.derivedResponses.LocationResponse;

public interface ILocationService {

	public boolean updateLocation(GpsLocationWithUsernameAndTime gpsLocationWithUsername) throws ParseException;

	public LocationResponse getCurrentLocation(String username);
}
