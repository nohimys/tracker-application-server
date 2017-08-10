package com.nohimys.service;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nohimys.dao.TrackeeInformationRepository;
import com.nohimys.entity.TrackeeInformation;
import com.nohimys.model.GpsLocation;
import com.nohimys.model.derivedResponses.GpsLocationWithUsernameAndTime;
import com.nohimys.model.derivedResponses.LocationResponse;

@Service
public class LocationService {

	@Autowired
	private TrackeeInformationRepository trackeeInformationRepository;

	public boolean updateLocation(GpsLocationWithUsernameAndTime gpsLocationWithUsername) throws ParseException {
		
		TrackeeInformation trackeeInformation = trackeeInformationRepository
				.findOne(gpsLocationWithUsername.getUsername());

		if (trackeeInformation != null) {
			BigDecimal latitude = gpsLocationWithUsername.getGpsLocation().getLatitude();
			BigDecimal longitude = gpsLocationWithUsername.getGpsLocation().getLongitude();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(gpsLocationWithUsername.getReportedDateTime());
			//System.out.println(date.toString());
			Timestamp  reportedTime = new Timestamp(date.getTime());

			if (latitude != null && !latitude.equals(0.0)) {
				trackeeInformation.setLastLatitude(latitude);
			}

			if (longitude != null && !latitude.equals(0.0)) {
				trackeeInformation.setLastLongitude(longitude);
			}
			
			if(reportedTime != null) {
				trackeeInformation.setReportedTime(reportedTime);
			}
			
			boolean isConfigurationsUpdated = trackeeInformation.isConfigurationUpdated();
			
			trackeeInformationRepository.save(trackeeInformation);
			return isConfigurationsUpdated;
		}
		return false;
	}

	public LocationResponse getCurrentLocation(String username) {
		LocationResponse locationResponse = new LocationResponse();

		TrackeeInformation trackeeInformation = trackeeInformationRepository.findOne(username);

		if (trackeeInformation != null) {
			locationResponse.setFriendlyName(trackeeInformation.getFriendlyName());
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			locationResponse.setReportedTime(dateFormat.format(new Date(trackeeInformation.getReportedTime().getTime())));
			locationResponse.setConfigurationUpdated(trackeeInformation.isConfigurationUpdated());
			locationResponse.setGpsLocation(
					new GpsLocation(trackeeInformation.getLastLatitude(), trackeeInformation.getLastLongitude()));
		}
		return locationResponse;
	}
}
