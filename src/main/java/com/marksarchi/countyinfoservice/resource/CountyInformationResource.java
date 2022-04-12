package com.marksarchi.countyinfoservice.resource;


import com.marksarchi.countyinfoservice.domain.CountyInformation;
import com.marksarchi.countyinfoservice.services.CountyInformationService;
import com.marksarchi.countyinfoservice.services.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information")
public class CountyInformationResource {

    @Autowired
    ScraperService scraperService;

    @Autowired
    CountyInformationService service;

    @GetMapping
    public String countyInfo() {
        return scraperService.extractCountyData();
    }

    @GetMapping("/all")
    public List<CountyInformation> fetchAllCountyInformation() {
        return service.fetchAll();
    }
    @GetMapping("/county")
    public ResponseEntity fetchCountyInfo(@RequestParam String name) {
        var resp =  service.fetchCountyInfo(name);
        return ResponseEntity.status(resp.getCode()).body(resp);
    }

    @PostMapping
    public CountyInformation createCountyInfo(@RequestBody CountyInformation information) {
        return service.createCountyInfo(information);
    }
    @PostMapping("/counties")
    public List<CountyInformation> createCountiesInfo(@RequestBody List<CountyInformation> information) {
        return service.createCountiesInfo(information);
    }
}
