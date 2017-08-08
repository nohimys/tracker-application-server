package com.nohimys.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.nohimys.entity.TrackeeUser;

@Service
public class UserManagementService {

	public boolean validateLogin(String username, String password) {
		if(username.equals("nohim") && password.equals("123")) {
			return true;
		}
		return false;
	}
	
	public Collection<TrackeeUser> getAllTrackeeUsers() {
		Collection<TrackeeUser> collection = new ArrayList<TrackeeUser>();
		
		collection.add(new TrackeeUser("alex","Alex Dude"));
		collection.add(new TrackeeUser("samantha","Samantha Siriwardana"));
		
		return collection;
	}
}
