package com.alevel.trucking.model.route.openstreetmap.ru;

import com.alevel.trucking.model.address.Address;
import com.alevel.trucking.model.route.util.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class RequestMatches {

    private String url = "http://openstreetmap.ru/api/search";

    public ResponseMatches request(Address address) {
        RestTemplate restTemplate = RestTemplateBuilder.build();
        String urlRequest = this.url + "q=" +
                address.getCity().toString() + "," +
                address.getStreet().toString() + "," +
                address.getBuilding().toString();
        ResponseMatches responseMatches = restTemplate.getForObject(urlRequest, ResponseMatches.class);
        return responseMatches;
    }

}
