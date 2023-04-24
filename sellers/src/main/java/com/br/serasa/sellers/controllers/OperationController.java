package com.br.serasa.sellers.controllers;

import com.br.serasa.sellers.models.OperationDto;
import com.br.serasa.sellers.service.OperationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operation")
@AllArgsConstructor
@NoArgsConstructor
public class OperationController {

    @Autowired
    private OperationService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OperationDto request) {

        service.save(request);
    }
}
