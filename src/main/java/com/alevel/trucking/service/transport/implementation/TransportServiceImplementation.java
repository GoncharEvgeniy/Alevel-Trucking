package com.alevel.trucking.service.transport.implementation;

import com.alevel.trucking.error.exception.TransportNotFoundException;
import com.alevel.trucking.model.goods.Goods;
import com.alevel.trucking.model.order.Order;
import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.transport.TransportStatus;
import com.alevel.trucking.repository.TransportRepository;
import com.alevel.trucking.service.order.OrderService;
import com.alevel.trucking.service.transport.TransportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportServiceImplementation implements TransportService {

    private final TransportRepository transportRepository;

    private final OrderService orderService;

    public TransportServiceImplementation(TransportRepository transportRepository, OrderService orderService) {
        this.transportRepository = transportRepository;
        this.orderService = orderService;
    }

    @Override
    public boolean save(Transport transport) {
        Transport transportFromDb = transportRepository
                .findByLicensePlateNumber(transport.getLicensePlateNumber());
        if (transportFromDb != null) {
            return false;
        }
        transport.setStatus(TransportStatus.IN_BOX);
        transportRepository.save(transport);
        return true;
    }

    @Override
    public List<Transport> getValidTransportsForOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId);
        List<Goods> goods = order.getGoods();
        return goods.stream()
                .map(this::getTransportForGoods)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transport> getTransportByListId(List<Long> listId) {
        List<Transport> transportList = new ArrayList<>();
        for (Long id : listId) {
            Transport transport = transportRepository
                    .findById(id)
                    .orElseThrow(() -> new TransportNotFoundException(id));
            transportList.add(transport);
        }
        return transportList;
    }

    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transports = transportRepository.findAll();
        if (transports.size() == 0) {
            throw new TransportNotFoundException();
        } else {
            return transports;
        }
    }

    private Transport getTransportForGoods(Goods goods) {
        if (goods.getVolume() == 0) {
            List<Transport> transports = transportRepository.findAllByMaxWidthOfGoodsGreaterThanAndMaxHeightOfGoodsGreaterThanAndMaxLengthOfGoodsGreaterThanAndLoadCapacityGreaterThanAndStatusOrderByLoadCapacity(
                    goods.getWidth(),
                    goods.getHeight(),
                    goods.getLength(),
                    goods.getWeight(),
                    TransportStatus.IN_BOX
            );
            if (transports.size() == 0) {
                throw new TransportNotFoundException();
            } else {
                return transports.get(0);
            }
        } else {
            List<Transport> transports = transportRepository.findAllByMaxVolumeOfGoodsGreaterThanEqualAndStatusOrderByLoadCapacity(
                    goods.getVolume(),
                    TransportStatus.IN_BOX
            );
            if (transports.size() == 0) {
                throw new TransportNotFoundException();
            } else {
                return transports.get(0);
            }
        }
    }
}
