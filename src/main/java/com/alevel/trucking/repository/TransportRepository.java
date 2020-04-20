package com.alevel.trucking.repository;

import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.transport.TransportStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport, Long> {

    Transport findByLicensePlateNumber(String plateNumber);

    List<Transport> findAllByMaxWidthOfGoodsGreaterThanAndMaxHeightOfGoodsGreaterThanAndMaxLengthOfGoodsGreaterThanAndLoadCapacityGreaterThanAndStatusOrderByLoadCapacity(
            int width, int height, int length, int loadCapacity, TransportStatus status
    );

    List<Transport> findAllByMaxVolumeOfGoodsGreaterThanEqualAndStatusOrderByLoadCapacity(
            int volume, TransportStatus status
    );
}
