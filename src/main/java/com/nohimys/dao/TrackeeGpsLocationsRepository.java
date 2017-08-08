package com.nohimys.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nohimys.entity.TrackeeGpsLocations;
import com.nohimys.entity.TrackeeGpsLocationsKey;

@Repository
public interface TrackeeGpsLocationsRepository extends CrudRepository<TrackeeGpsLocations, TrackeeGpsLocationsKey>{

}
