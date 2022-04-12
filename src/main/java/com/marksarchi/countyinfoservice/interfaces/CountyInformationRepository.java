package com.marksarchi.countyinfoservice.interfaces;


import com.marksarchi.countyinfoservice.domain.CountyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountyInformationRepository extends JpaRepository<CountyInformation,Long> {
   Optional<CountyInformation>  findCountyInformationByName(String name);
}
