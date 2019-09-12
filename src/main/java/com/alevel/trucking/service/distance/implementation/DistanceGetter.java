package com.alevel.trucking.service.distance.implementation;

import com.alevel.trucking.model.address.Address;
import com.alevel.trucking.service.distance.Distance;
import com.alevel.trucking.service.distance.openstreetmap.ru.RequestMatches;
import com.alevel.trucking.service.distance.openstreetmap.ru.ResponseMatches;
import com.alevel.trucking.service.distance.project.osrm.org.RequestRoutes;
import com.alevel.trucking.service.distance.project.osrm.org.ResponseRoutes;
import org.springframework.stereotype.Component;

@Component
public class DistanceGetter implements Distance {
    @Override
    public double getDistance(Address addressStart, Address addressEnd) {
        RequestMatches requestMatches = new RequestMatches();
        ResponseMatches responseMatchesStart = requestMatches.request(addressStart);
        ResponseMatches responseMatchesEnd = requestMatches.request(addressEnd);
        RequestRoutes requestRoutes = new RequestRoutes();
        ResponseRoutes responseRoutes = requestRoutes.request(responseMatchesStart.getMatches().get(0),
                responseMatchesEnd.getMatches().get(0));
        return responseRoutes.getRoutes().get(0).getDistance();
    }
}
