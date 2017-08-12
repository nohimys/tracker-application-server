package com.nohimys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nohimys.dao.TrackeeGpsLocationsRepository;
import com.nohimys.dao.TrackeeInformationRepository;
import com.nohimys.entity.TrackeeGpsLocations;
import com.nohimys.entity.TrackeeInformation;
import com.nohimys.model.GpsLocation;
import com.nohimys.model.derivedResponses.GpsLocationWithUsernameAndTime;
import com.nohimys.model.derivedResponses.LocationResponse;
import com.nohimys.util.DateTimeConverter;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	private TrackeeInformationRepository trackeeInformationRepository;

	@Autowired
	private TrackeeGpsLocationsRepository trackeeGpsLocationsRepository;

	public boolean updateLocation(GpsLocationWithUsernameAndTime gpsLocationWithUsername) throws ParseException {

		TrackeeInformation trackeeInformation = trackeeInformationRepository
				.findOne(gpsLocationWithUsername.getUsername());

		if (trackeeInformation != null) {
			BigDecimal latitude = gpsLocationWithUsername.getGpsLocation().getLatitude();
			BigDecimal longitude = gpsLocationWithUsername.getGpsLocation().getLongitude();

			Timestamp reportedTime = DateTimeConverter
					.getTimestampFromString(gpsLocationWithUsername.getReportedDateTime());

			// Also add to the Trackee GPS Locations Table
			TrackeeGpsLocations trackeeGpsLocations = new TrackeeGpsLocations();
			trackeeGpsLocations.setUsername(gpsLocationWithUsername.getUsername());

			if (latitude != null && !latitude.equals(0.0)) {
				trackeeInformation.setLastLatitude(latitude);
				trackeeGpsLocations.setLastLatitude(latitude);
			}

			if (longitude != null && !latitude.equals(0.0)) {
				trackeeInformation.setLastLongitude(longitude);
				trackeeGpsLocations.setLastLongitude(longitude);
			}

			if (reportedTime != null) {
				trackeeInformation.setReportedTime(reportedTime);
				trackeeGpsLocations.setReportedTime(reportedTime);
			}

			boolean isConfigurationsUpdated = trackeeInformation.isConfigurationUpdated();

			// Also save to the Trackee GPS Locations Table
			trackeeGpsLocationsRepository.save(trackeeGpsLocations);

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

			if (trackeeInformation.getReportedTime() != null) {
				locationResponse.setReportedTime(
						DateTimeConverter.getStringFromTimestamp(trackeeInformation.getReportedTime()));
			}
			locationResponse.setConfigurationUpdated(trackeeInformation.isConfigurationUpdated());
			locationResponse.setGpsLocation(
					new GpsLocation(trackeeInformation.getLastLatitude(), trackeeInformation.getLastLongitude()));
		}
		return locationResponse;
	}
}
