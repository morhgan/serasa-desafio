package com.br.serasa.sellers.service;

import com.br.serasa.sellers.mappers.OperationMapper;
import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.OperationDto;
import com.br.serasa.sellers.repository.OperationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class OperationService {

    @Autowired
    private OperationRepository repository;

    public void save(OperationDto request) {

        Operation operation = OperationMapper.INSTANCE.dtoToEntity(request);
        Optional<Operation> foundOperation = findOperation(request.getRegion());
        if (foundOperation.isPresent()) {
            operation.setId(foundOperation.get().getId());
        }
        Operation savedOperation = repository.save(operation);
        log.info("Operation saved {}", savedOperation);
    }

    public Optional<Operation> findOperation(String region) {
        return repository.findByRegion(region);
    }
}
