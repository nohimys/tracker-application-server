package com.nohimys.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.IdClass;

/*
 * trackee_gps_locations table has composite primary key
 * This class is used to represent that composite primary key in JPA
 * In the entity @IdClass annotation is used with this class name
 * Then only those both properties has to be decorated with the @Id annotation
 * */
public class TrackeeGpsLocationsKey implements Serializable{
	
	private String username;
	private Timestamp reportedTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(Timestamp reportedTime) {
		this.reportedTime = reportedTime;
	}
	
}
