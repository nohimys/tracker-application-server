package com.nohimys.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nohimys.dao.TrackeeInformationRepository;
import com.nohimys.entity.TrackeeInformation;
import com.nohimys.model.TrackeeUser;

@Service
public class UserManagementService {
	
	@Autowired
	private TrackeeInformationRepository trackeeInformationRepository;

	public boolean validateLogin(String username, String password) {
		if(username.equals("nohim") && password.equals("123")) {
			return true;
		}
		return false;
	}
	
	public Collection<TrackeeUser> getAllTrackeeUsers() {
		
		Iterable<TrackeeInformation> trackeeInformationIterator = trackeeInformationRepository.findAll();
		
		Collection<TrackeeUser> collection = new ArrayList<TrackeeUser>();
		
		for (TrackeeInformation trackeeInformation : trackeeInformationIterator) {
			collection.add(new TrackeeUser(trackeeInformation.getUsername(),trackeeInformation.getFriendlyName()));	
		}
		
		return collection;
	}
}
