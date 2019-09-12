package com.alevel.trucking.service.transport.implementation;

import com.alevel.trucking.model.transport.Transport;
import com.alevel.trucking.model.transport.TransportStatus;
import com.alevel.trucking.repository.TransportRepository;
import com.alevel.trucking.service.transport.TransportService;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImplementation implements TransportService {

    private final TransportRepository transportRepository;

    public TransportServiceImplementation(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
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
}
