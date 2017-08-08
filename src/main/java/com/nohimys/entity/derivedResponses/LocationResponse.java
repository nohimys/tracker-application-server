package com.nohimys.entity.derivedResponses;

import com.nohimys.entity.GpsLocation;

public class LocationResponse {

	private GpsLocation gpsLocation;
	private String friendlyName;
	private String reportedTime;
	private boolean isConfigurationUpdated;
	public GpsLocation getGpsLocation() {
		return gpsLocation;
	}
	public void setGpsLocation(GpsLocation gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getReportedTime() {
		return reportedTime;
	}
	public void setReportedTime(String reportedTime) {
		this.reportedTime = reportedTime;
	}
	public boolean isConfigurationUpdated() {
		return isConfigurationUpdated;
	}
	public void setConfigurationUpdated(boolean isConfigurationUpdated) {
		this.isConfigurationUpdated = isConfigurationUpdated;
	}
	
	
}
