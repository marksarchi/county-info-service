package com.marksarchi.countyinfoservice.services;

import com.marksarchi.countyinfoservice.domain.CountyInformation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ScraperService {

    CountyInformationService countyInformationService;

    private final String url = "https://www.devolution.go.ke/county-information/";


    List<CountyInformation> countyInformations = new ArrayList<>();

    public List<CountyInformation> extractCountyData() {
        try {
            Document document = Jsoup.connect(url).get();
            for (Element table : document.select("tbody")) {
                var rows = table.select("tr");
                for (int i = 1; i <= rows.size() - 1; i++) {

                    Elements tds = rows.get(i).select("td");
                    var countyInformation = mapCountyInfo(tds);
                    countyInformations.add(countyInformation);

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return countyInformationService.persistCountyInfos(countyInformations);
    }

    public CountyInformation mapCountyInfo(Elements tds) {

        CountyInformation countyInformation = new CountyInformation();
        for (int i = 0; i <= tds.size() - 1; i++) {

            switch (i) {
                case 0:
                    countyInformation.setCode(tds.get(i).text());
                    break;
                case 1:
                    countyInformation.setName(tds.get(i).text());
                    break;
                case 2:
                    countyInformation.setArea(tds.get(i).text());
                    break;
                case 3:
                    countyInformation.setPopulation_2009(tds.get(i).text());
                    break;
                case 4:
                    countyInformation.setCapital(tds.get(i).text());
                    break;
                case 5:
                    countyInformation.setGovernor(tds.get(i).text());
                    break;
                case 6:
                    countyInformation.setDeputyGovernor(tds.get(i).text());
                    break;
                case 7:
                    countyInformation.setWomenRepresentative(tds.get(i).text());
                    break;
                case 8:
                    countyInformation.setEconomicActivities(tds.get(i).text());
                    break;

            }
        }
        return countyInformation;
    }

}
