package com.nohimys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracker")
public class TrackerController {

	@RequestMapping("/getCurrentLocation")
    public boolean getCurrentLocation() {
        return true;
    }
}
