package com.nohimys.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nohimys.entity.TrackerInformation;

@Repository
public interface TrackerInformationRepository extends CrudRepository<TrackerInformation, String> {

}
