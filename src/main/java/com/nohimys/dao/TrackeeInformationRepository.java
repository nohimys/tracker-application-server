package com.nohimys.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nohimys.entity.TrackeeInformation;

@Repository
public interface TrackeeInformationRepository extends CrudRepository<TrackeeInformation, String>{

}
