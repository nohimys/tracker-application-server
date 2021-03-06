package com.nohimys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nohimys.dao.TrackeeInformationRepository;
import com.nohimys.entity.TrackeeInformation;
import com.nohimys.model.Configuration;
import com.nohimys.model.derivedResponses.ConfigurationWithUsername;

@Service
public class ConfigurationServiceImpl implements IConfigurationService{
	
	@Autowired
	private TrackeeInformationRepository trackeeInformationRepository;

	public Configuration seekConfiguration(String username,boolean isSeekedByTrackee) {
		
		Configuration configuration = new Configuration();
		
		TrackeeInformation trackeeInformation = trackeeInformationRepository.findOne(username);
		
		if(trackeeInformation != null)
		{
			configuration.setUploadingDurationInMinutes(trackeeInformation.getUploadingDurationInMins());
			configuration.setTimerTickDurationInMinutes(trackeeInformation.getTimerTickDurationInMins());
			
			//Make it false after the configuration is been seek
			if(isSeekedByTrackee) {
				trackeeInformation.setConfigurationUpdated(false);
				//Save the object to the table, if it is updated
				trackeeInformationRepository.save(trackeeInformation);
			}			
		}		
		return configuration;
	}
	
	public boolean updateConfiguration(ConfigurationWithUsername gpsLocationWithUsername) {
		
		TrackeeInformation trackeeInformation = trackeeInformationRepository.findOne(gpsLocationWithUsername.getUsername());
		
		if(trackeeInformation != null) {
			
			int oldUploadingDuration = trackeeInformation.getUploadingDurationInMins();
			int oldTimerTickDuration = trackeeInformation.getTimerTickDurationInMins();
			int newUploadingDuration = gpsLocationWithUsername.getConfiguration().getUploadingDurationInMinutes();
			int newTimerTickDuration = gpsLocationWithUsername.getConfiguration().getTimerTickDurationInMinutes();
			
			//Update new configuration values in the table
			
			if(newUploadingDuration != oldUploadingDuration) {
				trackeeInformation.setUploadingDurationInMins(newUploadingDuration);
			}
			
			if(newTimerTickDuration != oldTimerTickDuration) {
				trackeeInformation.setTimerTickDurationInMins(newTimerTickDuration);
			}
			
			if(newUploadingDuration != oldUploadingDuration || newTimerTickDuration != oldTimerTickDuration) {
				//Make the isConfigurationsUpdated boolean value true
				trackeeInformation.setConfigurationUpdated(true);
				
				trackeeInformationRepository.save(trackeeInformation);
			}
			
			return true;
		}		
		return false;
	}
}
