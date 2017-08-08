package com.nohimys.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trackee_information")
public class TrackeeInformation {

	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "device_id")
	private String deviceId;
	
	@Column(name = "friendly_name")
	private String friendlyName;
	
	@Column(name = "last_latitude")
	private BigDecimal lastLatitude;
	
	@Column(name = "last_longitude")
	private BigDecimal lastLongitude;
	
	@Column(name = "reported_time")
	private Date reportedTime;
	
	@Column(name = "uploading_duration_in_mins")
	private int uploadingDurationInMins;
	
	@Column(name = "timer_tick_duration_in_mins")
	private int timerTickDurationInMins;
	
	@Column(name = "is_configuration_updated")
	private boolean isConfigurationUpdated;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
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

	public Date getReportedTime() {
		return reportedTime;
	}

	public void setReportedTime(Date reportedTime) {
		this.reportedTime = reportedTime;
	}

	public int getUploadingDurationInMins() {
		return uploadingDurationInMins;
	}

	public void setUploadingDurationInMins(int uploadingDurationInMins) {
		this.uploadingDurationInMins = uploadingDurationInMins;
	}

	public int getTimerTickDurationInMins() {
		return timerTickDurationInMins;
	}

	public void setTimerTickDurationInMins(int timerTickDurationInMins) {
		this.timerTickDurationInMins = timerTickDurationInMins;
	}

	public boolean isConfigurationUpdated() {
		return isConfigurationUpdated;
	}

	public void setConfigurationUpdated(boolean isConfigurationUpdated) {
		this.isConfigurationUpdated = isConfigurationUpdated;
	}
	
	
}
