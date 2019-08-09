package com.alevel.trucking.service.distance;

import com.alevel.trucking.model.address.Address;

public interface Distance {

    double getDistance(Address addressStart, Address addressEnd);

}
