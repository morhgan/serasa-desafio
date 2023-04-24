package com.br.serasa.sellers.controllers;

import com.br.serasa.sellers.models.SellerDto;
import com.br.serasa.sellers.service.SellerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/seller")
@AllArgsConstructor
@NoArgsConstructor
public class SellerController {

    @Autowired
    private SellerService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SellerDto request) {

        service.save(request);
    }
}
