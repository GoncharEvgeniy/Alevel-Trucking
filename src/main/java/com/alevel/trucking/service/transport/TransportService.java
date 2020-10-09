package com.alevel.trucking.service.transport;

import com.alevel.trucking.error.exception.TransportExistException;
import com.alevel.trucking.error.exception.TransportNotFoundException;
import com.alevel.trucking.model.transport.Transport;

import java.util.List;

public interface TransportService {

    boolean save(Transport transport) throws TransportExistException;

    List<Transport> getValidTransportsForOrder(Long orderId) throws TransportNotFoundException;

    List<Transport> getTransportByListId(List<Long> listId) throws TransportNotFoundException;

    List<Transport> getAllTransport() throws TransportNotFoundException;
}
