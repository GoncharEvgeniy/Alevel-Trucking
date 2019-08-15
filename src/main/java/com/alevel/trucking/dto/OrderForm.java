package com.alevel.trucking.dto;

import com.alevel.trucking.model.goods.Goods;
import com.alevel.trucking.model.order.Order;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderForm implements Serializable {

    @NotNull
    private RouteDto routeDto;

    @NotNull
    private List<GoodsDto> goodsDtoList = new ArrayList<>();

    public static Order fromDto(OrderForm orderForm) {
        List<Goods> goods = orderForm.getGoodsDtoList()
                .stream()
                .map(GoodsDto::fromDto)
                .collect(Collectors.toList());
        return Order.builder()
                .route(RouteDto.fromDto(orderForm.getRouteDto()))
                .goods(goods)
                .build();
    }

    public List<GoodsDto> getGoodsDtoList() {
        return goodsDtoList;
    }

    public void setGoodsDtoList(List<GoodsDto> goodsDtoList) {
        this.goodsDtoList = goodsDtoList;
    }

    public RouteDto getRouteDto() {
        return routeDto;
    }

    public void setRouteDto(RouteDto routeDto) {
        this.routeDto = routeDto;
    }
}
