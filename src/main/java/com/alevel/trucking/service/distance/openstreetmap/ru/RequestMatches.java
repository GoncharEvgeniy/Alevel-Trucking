package com.alevel.trucking.service.distance.openstreetmap.ru;

import com.alevel.trucking.model.address.Address;
import com.alevel.trucking.service.distance.util.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class RequestMatches {

    private String url = "http://openstreetmap.ru/api/search?";

    public ResponseMatches request(Address address) {
        RestTemplate restTemplate = RestTemplateBuilder.build();
        String urlRequest = this.url + "q=" +
                address.getCity().getName() + "," +
                address.getStreet().getName() + "," +
                address.getBuilding().getNumber();
        ResponseMatches responseMatches = restTemplate.getForObject(urlRequest, ResponseMatches.class);
        return responseMatches;
    }

}
