package com.alevel.trucking.service.distance.project.osrm.org;

import com.alevel.trucking.service.distance.util.RestTemplateBuilder;
import com.alevel.trucking.service.distance.openstreetmap.ru.Match;
import org.springframework.web.client.RestTemplate;

public class RequestRoutes {

    private String url = "http://router.project-osrm.org/route/v1/driving/";

    public ResponseRoutes request(Match matchStart, Match matchEnd) {
        RestTemplate restTemplate = RestTemplateBuilder.build();
        String urlRequest3 = url +
                matchStart.getLon() + "," +
                matchStart.getLat() + ";" +
                matchEnd.getLon() + "," +
                matchEnd.getLat();
        ResponseRoutes responseRoutes = restTemplate.getForObject(urlRequest3, ResponseRoutes.class);
        return responseRoutes;
    }
}
