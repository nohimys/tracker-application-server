package com.nohimys.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nohimys.model.Configuration;
import com.nohimys.model.NewTrackeeUser;
import com.nohimys.model.derivedResponses.GpsLocationWithUsernameAndTime;
import com.nohimys.service.IConfigurationService;
import com.nohimys.service.LocationServiceImpl;
import com.nohimys.service.UserManagementServiceImpl;

@RestController
@RequestMapping("/trackee")
public class TrackeeController {
	
	@Autowired
	private IConfigurationService configurationService;
	
	@Autowired
	private LocationServiceImpl locationService;
	
	@Autowired
	private UserManagementServiceImpl userManagementService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/seek_configuration")
	public Configuration seekConfiguration(@RequestParam("username") String username) {
		return configurationService.seekConfiguration(username,true);
	}

	@RequestMapping(method = RequestMethod.PUT,value = "/update_location", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateLocation(@RequestBody GpsLocationWithUsernameAndTime gpsLocationWithUsername) throws ParseException {
		return locationService.updateLocation(gpsLocationWithUsername);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/is_trackee_username_available")
	public boolean isTrackeeUsernameAvailable(@RequestParam("username") String username) {
		return userManagementService.isTrackeeUsernameAvailable(username);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/add_new_trackee", consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean addNewTrackee(@RequestBody NewTrackeeUser newTrackeeUser) {
		return userManagementService.addNewTrackee(newTrackeeUser.getUserName(), newTrackeeUser.getDeviceId());
	}

}
