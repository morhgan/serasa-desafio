package com.br.serasa.sellers.service;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.Seller;
import com.br.serasa.sellers.models.SellerDto;
import com.br.serasa.sellers.repository.OperationRepository;
import com.br.serasa.sellers.repository.SellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerServiceTest {

    @InjectMocks
    private SellerService service;

    @Mock
    private OperationService operationService;

    @Mock
    private SellerRepository repository;

    @Mock
    private OperationRepository operationRepository;


    @Test
    void save() {
        SellerDto sellerDto = SellerDto.builder()
                .name("Name Teste")
                .phone("00000000000")
                .age("31")
                .city("Salvado")
                .state("BA")
                .region("Nordeste")
                .build();

        List<String> states = new java.util.ArrayList<>();
        states.add("MA");
        states.add("PI");
        states.add("CE");
        states.add("RN");
        states.add("PB");
        states.add("PE");
        states.add("AL");
        states.add("SE");
        states.add("BA");
        Operation operation = Operation.builder()
                .id(1L)
                .region("Nordeste")
                .states(states)
                .build();
        Seller seller = Seller.builder()
                .name("Name Teste")
                .phone("00000000000")
                .age(31L)
                .city("Salvador")
                .state("BA")
                .operation(operation)
                .build();

        when(operationService.findOperation(any())).thenReturn(Optional.ofNullable(operation));
        when(repository.save(any())).thenReturn(seller);
        service.save(sellerDto);
        verify(repository).save(any());

    }
}