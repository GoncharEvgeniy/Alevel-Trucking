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
    private RouteDto route;

    @NotNull
    private List<GoodsDto> goodsList = new ArrayList<>();

    public static Order fromDto(OrderForm orderForm) {
        List<Goods> goods = orderForm.getGoodsList()
                .stream()
                .map(GoodsDto::fromDto)
                .collect(Collectors.toList());
        return Order.builder()
                .route(RouteDto.fromDto(orderForm.getRoute()))
                .goods(goods)
                .build();
    }

    public List<GoodsDto> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsDto> goodsList) {
        this.goodsList = goodsList;
    }

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }
}
