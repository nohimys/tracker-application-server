create database tracker_application;
show databases;
use tracker_application;

create table tracker_information(
	username VARCHAR(30) primary key,
	login_password VARCHAR(80),
	device_id VARCHAR(60)
);

create table trackee_information(
	username VARCHAR(30) primary key,
	device_id VARCHAR(60),
	friendly_name VARCHAR(50),
	last_latitude DECIMAL(10, 8),
	last_longitude DECIMAL(10, 8),
	reported_time datetime,
	uploading_duration_in_mins int,
	timer_tick_duration_in_mins int,
	is_configuration_updated bool
);

create table trackee_gps_locations(
	username VARCHAR(30),
    reported_time datetime,
    last_latitude DECIMAL(10, 8),
	last_longitude DECIMAL(10, 8),
    
    constraint trackee_gps_locations_primary_key primary key(username,reported_time),
    constraint trackee_gps_locations_foreign_key1 foreign key(username) references  trackee_information(username)
);

insert into tracker_information values('nohimys','sliit123','0000');
insert into trackee_information values('samantha31','1111','Samantha',80.2222,70.5555,'2017-08-07 22:53:35',30,15,false);

select * from tracker_information;
select * from trackee_information;

drop table tracker_information;
drop table trackee_information;
drop table trackee_gps_locations;

show tables;