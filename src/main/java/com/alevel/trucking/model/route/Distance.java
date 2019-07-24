package com.alevel.trucking.model.route;

import com.alevel.trucking.model.address.Address;

public interface Distance {

    double getDistance(Address addressStart, Address addressEnd);

}
