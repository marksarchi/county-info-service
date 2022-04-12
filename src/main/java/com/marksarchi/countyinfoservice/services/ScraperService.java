package com.marksarchi.countyinfoservice.services;

import com.marksarchi.countyinfoservice.domain.CountyInformation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScraperService {

    String url  = "https://www.devolution.go.ke/county-information/";
    StringBuilder response   = new StringBuilder();

    List<CountyInformation> countyInformations = new ArrayList<>();
    public String extractCountyData(){
        try{
            Document document = Jsoup.connect(url).get();
            for (Element table : document.select("tbody")) {
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");
                   response.append(tds);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

}
