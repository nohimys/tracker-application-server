package com.nohimys.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nohimys.dao.TrackeeInformationRepository;
import com.nohimys.dao.TrackerInformationRepository;
import com.nohimys.entity.TrackeeInformation;
import com.nohimys.entity.TrackerInformation;
import com.nohimys.model.TrackeeUser;

@Service
public class UserManagementService {

	@Autowired
	private TrackeeInformationRepository trackeeInformationRepository;

	@Autowired
	private TrackerInformationRepository trackerInformationRepository;

	public boolean validateLogin(String username, String password) {

		TrackerInformation trackerInformation = trackerInformationRepository.findOne(username);

		if (trackerInformation != null && trackerInformation.getLoginPassword() != null
				&& trackerInformation.getLoginPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public Collection<TrackeeUser> getAllTrackeeUsers() {

		Iterable<TrackeeInformation> trackeeInformationIterator = trackeeInformationRepository.findAll();

		Collection<TrackeeUser> collection = new ArrayList<TrackeeUser>();

		if (trackeeInformationIterator != null) {
			for (TrackeeInformation trackeeInformation : trackeeInformationIterator) {
				collection.add(new TrackeeUser(trackeeInformation.getUsername(), trackeeInformation.getFriendlyName()));
			}
		}

		return collection;
	}
}
