package com.alevel.trucking.repository;

import com.alevel.trucking.model.transport.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {

    Transport findByLicensePlateNumber(String plateNumber);
}
