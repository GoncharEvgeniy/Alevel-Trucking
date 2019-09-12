package com.alevel.trucking.service.transport;

import com.alevel.trucking.model.transport.Transport;

import java.util.List;

public interface TransportService {

    boolean save(Transport transport);

    List<Transport> getValidTransportsForOrder(Long orderId);

    List<Transport> getTransportByListId(List<Long> listId);

    List<Transport> getAllTransport();
}
