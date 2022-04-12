package com.marksarchi.countyinfoservice.services;


import com.marksarchi.countyinfoservice.domain.CountyInformation;
import com.marksarchi.countyinfoservice.dtos.ResponseWrapper;
import com.marksarchi.countyinfoservice.interfaces.CountyInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountyInformationService {
    @Autowired
    CountyInformationRepository repository;

    public List<CountyInformation> fetchAll(){
        return repository.findAll();

    }
    public CountyInformation createCountyInfo(CountyInformation countyInformation){
        return repository.save(countyInformation);
    }

    public ResponseWrapper fetchCountyInfo(String name) {
       var resp =  repository.findCountyInformationByName(name.trim());
        if(resp.isPresent()){
           return ResponseWrapper.builder()
                    .code(HttpStatus.OK.value())
                    .data(resp.get())
                    .message("County information fetched successfully")
                   .build();
        }

        return  ResponseWrapper.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .data(null)
                .message("County information not found")
                .build();

    }

    public List<CountyInformation> createCountiesInfo(List<CountyInformation> information) {
        return repository.saveAll(information);
    }
}
