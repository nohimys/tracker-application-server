package com.nohimys.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nohimys.model.Configuration;
import com.nohimys.model.TrackeeUser;
import com.nohimys.model.derivedResponses.ConfigurationWithUsername;
import com.nohimys.model.derivedResponses.LocationResponse;
import com.nohimys.service.ConfigurationService;
import com.nohimys.service.LocationService;
import com.nohimys.service.UserManagementService;

@RestController
@RequestMapping("/tracker")
public class TrackerController {
	
	@Autowired
	private ConfigurationService configurationService;	
	@Autowired
	private UserManagementService userManagementService;
	@Autowired
	private LocationService locationService;

	@RequestMapping("/get_current_location")
	public LocationResponse getCurrentLocation(@RequestParam("username") String username) {
		return locationService.getCurrentLocation(username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/get_configuration")
	public Configuration getConfiguration(@RequestParam("username") String username) {
		return configurationService.seekConfiguration(username,false);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/update_configuration", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateConfiguration(@RequestBody ConfigurationWithUsername gpsLocationWithUsername) {
		return configurationService.updateConfiguration(gpsLocationWithUsername);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/validate_login")
	public boolean validateLogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		return userManagementService.validateLogin(username, password);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/get_all_trackee_users")
	public Collection<TrackeeUser> getAllTrackeeUsers() {
		return userManagementService.getAllTrackeeUsers();
	}
	
}
