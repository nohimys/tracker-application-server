package com.nohimys.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nohimys.entity.GpsLocation;
import com.nohimys.entity.TrackeeUser;
import com.nohimys.entity.derivedResponses.ConfigurationWithUsername;
import com.nohimys.entity.derivedResponses.LocationResponse;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

	@RequestMapping("/get_current_location")
	public LocationResponse getCurrentLocation(@RequestParam("username") String username) {
		LocationResponse locationResponse = new LocationResponse();
		if (username.equals("nohim")) {
			locationResponse.setFriendlyName("Nohim Sandeepa");
			locationResponse.setReportedTime("2017:08:08 15:56");
			locationResponse.setConfigurationUpdated(true);
			locationResponse.setGpsLocation(new GpsLocation("75.222","75.222"));
		}
		return locationResponse;
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/update_configuration", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateConfiguration(@RequestBody ConfigurationWithUsername gpsLocationWithUsername) {
		System.out.println(gpsLocationWithUsername.getUsername());
		System.out.println(gpsLocationWithUsername.getConfiguration().getTimerTickDurationInMinutes());
		System.out.println(gpsLocationWithUsername.getConfiguration().getUploadingDurationInMinutes());
		return true;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/validate_login")
	public boolean validateLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		if(username.equals("nohim") && password.equals("123")) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/get_all_trackee_users")
	public Collection<TrackeeUser> getAllTrackeeUsers() {
		Collection<TrackeeUser> collection = new ArrayList<TrackeeUser>();
		
		collection.add(new TrackeeUser("alex","Alex Dude"));
		collection.add(new TrackeeUser("samantha","Samantha Siriwardana"));
		
		return collection;
	}
	
}
