package com.nohimys.service;

import java.util.Collection;

import com.nohimys.model.TrackeeUser;

public interface IUserManagementService {

	public boolean isTrackeeUsernameAvailable(String username);

	public boolean addNewTrackee(String username, String deviceId);

	public boolean validateLogin(String username, String password);

	public Collection<TrackeeUser> getAllTrackeeUsers();
}
