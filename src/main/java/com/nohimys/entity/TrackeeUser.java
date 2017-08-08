package com.nohimys.entity;

public class TrackeeUser {
	private String userName;
	private String friendlyName;
	
	public TrackeeUser() {}
	
	public TrackeeUser(String userName, String friendlyName) {
		super();
		this.userName = userName;
		this.friendlyName = friendlyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	
}
