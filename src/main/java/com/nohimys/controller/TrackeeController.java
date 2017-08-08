package com.nohimys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nohimys.entity.Configuration;
import com.nohimys.entity.derivedResponses.GpsLocationWithUsername;
import com.nohimys.service.ConfigurationService;
import com.nohimys.service.LocationService;

@RestController
@RequestMapping("/trackee")
public class TrackeeController {
	
	@Autowired
	private ConfigurationService configurationService;
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/seek_configuration")
	public Configuration seekConfiguration(@RequestParam("username") String username) {
		return configurationService.seekConfiguration(username);
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/update_location", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateLocation(@RequestBody GpsLocationWithUsername gpsLocationWithUsername) {
		return locationService.updateLocation(gpsLocationWithUsername);
	}

}
