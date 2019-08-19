package com.alevel.trucking.service.transport.implementation;

import com.alevel.trucking.error.exception.OrderNotFoundException;
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
        Order order = orderService
                .getOrderById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId)); // Todo exception
        List<Transport> resultTransportList = new ArrayList<>();
        List<Goods> goods = order.getGoods();
        for (Goods tmpGoods : goods) {
            if (tmpGoods.getVolume() == 0) {
                resultTransportList.add(
                        transportRepository.findAllByMaxWidthOfGoodsGreaterThanAndMaxHeightOfGoodsGreaterThanAndMaxLengthOfGoodsGreaterThanAndLoadCapacityGreaterThanAndStatusOrderByLoadCapacity(
                                tmpGoods.getWidth(),
                                tmpGoods.getHeight(),
                                tmpGoods.getLength(),
                                tmpGoods.getWeight(),
                                TransportStatus.IN_BOX
                        ).get(0)
                );
            } else {
                resultTransportList.add(
                    transportRepository.findAllByMaxVolumeOfGoodsGreaterThanEqualAndStatusOrderByLoadCapacity(
                            tmpGoods.getVolume(),
                            TransportStatus.IN_BOX
                    ).get(0)
                );
            }
        }
        return resultTransportList;
    }

    @Override
    public List<Transport> getTransportByListId(List<Long> listId) {
        List<Transport> transportList = new ArrayList<>();
        for (Long id: listId) {
            Transport transport = transportRepository.findById(id).get(); //Todo exception
            transportList.add(transport);
        }
        return transportList;
    }

    @Override
    public List<Transport> getAllTransport() {
        return transportRepository.findAll();
    }
}
