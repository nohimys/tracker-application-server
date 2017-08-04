package com.nohimys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trackee")
public class TrackeeController {
	
	@RequestMapping("/updateLocation")
    public boolean updateLocation() {
        return true;
    }

}
