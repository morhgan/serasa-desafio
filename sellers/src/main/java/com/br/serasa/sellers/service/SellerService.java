package com.br.serasa.sellers.service;

import com.br.serasa.sellers.mappers.SellerMapper;
import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.SellerDto;
import com.br.serasa.sellers.models.Seller;
import com.br.serasa.sellers.repository.SellerRepository;
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
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private OperationService operationService;

    public void save (SellerDto request) {

        Seller seller = SellerMapper.INSTANCE.dtoToEntity(request);
        Optional<Operation> foundOperation = operationService.findOperation(seller.getOperation().getRegion());
        if (foundOperation.isPresent()) {
            seller.setOperation(foundOperation.get());
        } else {
            log.error("Operation does not exist");
            log.error("Seller not saved");
            return;
        }
        Seller savedSeller = repository.save(seller);
        log.info("Saved seller {}", savedSeller);
    }
}
