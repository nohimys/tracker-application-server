package com.nohimys.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nohimys.entity.Configuration;
import com.nohimys.entity.derivedResponses.GpsLocationWithUsername;

@RestController
@RequestMapping("/trackee")
public class TrackeeController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/seek_configuration")
	public Configuration seekConfiguration(@RequestParam("username") String username) {
		Configuration configuration = new Configuration();
		if (username.equals("nohim")) {
			configuration.setUploadingDurationInMinutes(60);
			configuration.setTimerTickDurationInMinutes(15);
		}
		return configuration;
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/update_location", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateLocation(@RequestBody GpsLocationWithUsername gpsLocationWithUsername) {
		System.out.println(gpsLocationWithUsername.getUsername());
		System.out.println(gpsLocationWithUsername.getGpsLocation().getLatitude());
		System.out.println(gpsLocationWithUsername.getGpsLocation().getLongitude());
		return true;
	}

}
