package com.alevel.trucking.dto;

import com.alevel.trucking.model.route.Route;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RouteDto implements Serializable {

    @NotNull
    private AddressDto start;

    @NotNull
    private AddressDto end;

    public static Route fromDto(RouteDto routeDto) {
        return Route.builder()
                .start(AddressDto.fromDto(routeDto.getStart()))
                .end(AddressDto.fromDto(routeDto.getEnd()))
                .build();
    }

    public AddressDto getStart() {
        return start;
    }

    public void setStart(AddressDto start) {
        this.start = start;
    }

    public AddressDto getEnd() {
        return end;
    }

    public void setEnd(AddressDto end) {
        this.end = end;
    }
}
