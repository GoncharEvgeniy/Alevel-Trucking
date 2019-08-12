package com.alevel.trucking.service.transport;

import com.alevel.trucking.model.goods.Goods;
import com.alevel.trucking.model.transport.Transport;

import java.util.List;

public interface TransportService {

    boolean save(Transport transport);

    List<Transport> getValidTransportsForGoods(List<Goods> goods);

    List<Transport> getTransportByListId(List<Long> listId);
}
