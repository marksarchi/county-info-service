package com.marksarchi.countyinfoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "county_information")
@NoArgsConstructor
public class CountyInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @JsonProperty("county")
    public String name;
    public String code;
    public String area;
    public String population_2009;
    public String population_2019;
    public String capital;
    public String governor;
    public String deputyGovernor;
    public String womenRepresentative;
    public String economicActivities;
}
