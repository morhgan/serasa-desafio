package com.br.serasa.sellers.service;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.OperationDto;
import com.br.serasa.sellers.repository.OperationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @InjectMocks
    private OperationService service;

    @Mock
    private OperationRepository repository;

    @Test
    void save() {
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
        OperationDto operationDto = OperationDto.builder()
                .region("Nordeste")
                .states(states)
                .build();
        Operation operationEntity = Operation.builder()
                .id(1L)
                .region("Nordeste")
                .states(states)
                .build();
        when(repository.save(any())).thenReturn(operationEntity);
        service.save(operationDto);
        verify(repository).save(any());
    }
}