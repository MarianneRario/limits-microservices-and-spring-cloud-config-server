package com.rariom.microservices.limitsservice.controller;

import com.rariom.microservices.limitsservice.bean.Limits;
import com.rariom.microservices.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/limits")
public class LimitsController {

    @Autowired
    private Configuration configuration; 

    @GetMapping
    public Limits retrieveLimits(){
        return new Limits(
                // these will pick up what we have configured in local git repository "limits-service.properties"
                // not what we have defined in application.properties
                // because this has been connected to cloud config server
                // git repository has higher priority than application.properties
                configuration.getMinimum(),
                configuration.getMaximum()
        );
    }
}
