package com.marksarchi.countyinfoservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "county_information")
@NoArgsConstructor
public class CountyInformation {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "UUID")
    private UUID id;
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
