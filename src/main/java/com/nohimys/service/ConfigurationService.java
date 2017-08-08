package com.nohimys.service;

import org.springframework.stereotype.Service;

import com.nohimys.model.Configuration;
import com.nohimys.model.derivedResponses.ConfigurationWithUsername;

@Service
public class ConfigurationService {

	public Configuration seekConfiguration(String username) {
		Configuration configuration = new Configuration();
		if (username.equals("nohim")) {
			configuration.setUploadingDurationInMinutes(60);
			configuration.setTimerTickDurationInMinutes(15);
		}
		return configuration;
	}
	
	public boolean updateConfiguration(ConfigurationWithUsername gpsLocationWithUsername) {
		System.out.println(gpsLocationWithUsername.getUsername());
		System.out.println(gpsLocationWithUsername.getConfiguration().getTimerTickDurationInMinutes());
		System.out.println(gpsLocationWithUsername.getConfiguration().getUploadingDurationInMinutes());
		return true;
	}
}
