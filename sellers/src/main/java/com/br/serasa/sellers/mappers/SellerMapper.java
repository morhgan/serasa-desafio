package com.br.serasa.sellers.mappers;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.SellerDto;
import com.br.serasa.sellers.models.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerMapper {

    SellerMapper INSTANCE = Mappers.getMapper(SellerMapper.class);
    @Mapping(target = "inclusionDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "operation", expression = "java(mapOperation(request.getRegion()))")
    Seller dtoToEntity(SellerDto request);
    @Mapping(target = "region", source = "value")
    Operation mapOperation(String value);
}
