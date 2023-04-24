package com.br.serasa.sellers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto {
    @NotNull
    private String name;
    private String phone;
    private String age;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String region;
}