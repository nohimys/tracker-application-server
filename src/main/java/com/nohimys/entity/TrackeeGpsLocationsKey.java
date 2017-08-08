package com.nohimys.entity;

import java.io.Serializable;
import java.sql.Date;

public class TrackeeGpsLocationsKey implements Serializable{
	
	private String username;
	private Date reportedTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(Date reportedTime) {
		this.reportedTime = reportedTime;
	}
	
}
