package com.nohimys.service;

import com.nohimys.model.Configuration;
import com.nohimys.model.derivedResponses.ConfigurationWithUsername;

public interface IConfigurationService {

	public Configuration seekConfiguration(String username, boolean isSeekedByTrackee);

	public boolean updateConfiguration(ConfigurationWithUsername gpsLocationWithUsername);
}
