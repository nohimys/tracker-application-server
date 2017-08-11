package com.nohimys.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TrackeeGpsLocationsKey.class)
public class TrackeeGpsLocations {

	@Id
	@Column(name = "username")
	private String username;
	
	@Id
	@Column(name = "reported_time")
	private Timestamp reportedTime;
	
	@Column(name = "last_latitude")
	private BigDecimal lastLatitude;
	
	@Column(name = "last_longitude")
	private BigDecimal lastLongitude;

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

	public BigDecimal getLastLatitude() {
		return lastLatitude;
	}

	public void setLastLatitude(BigDecimal lastLatitude) {
		this.lastLatitude = lastLatitude;
	}

	public BigDecimal getLastLongitude() {
		return lastLongitude;
	}

	public void setLastLongitude(BigDecimal lastLongitude) {
		this.lastLongitude = lastLongitude;
	}
	
	
}
