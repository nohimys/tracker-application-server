package com.nohimys.model;

public class Configuration {
	private int uploadingDurationInMinutes;
	private int timerTickDurationInMinutes;
	public int getUploadingDurationInMinutes() {
		return uploadingDurationInMinutes;
	}
	public void setUploadingDurationInMinutes(int uploadingDurationInMinutes) {
		this.uploadingDurationInMinutes = uploadingDurationInMinutes;
	}
	public int getTimerTickDurationInMinutes() {
		return timerTickDurationInMinutes;
	}
	public void setTimerTickDurationInMinutes(int timerTickDurationInMinutes) {
		this.timerTickDurationInMinutes = timerTickDurationInMinutes;
	}
	
	

}
