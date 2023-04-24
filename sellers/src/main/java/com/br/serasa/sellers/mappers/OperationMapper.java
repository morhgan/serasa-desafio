package com.br.serasa.sellers.mappers;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.OperationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {

    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);
    Operation dtoToEntity(OperationDto request);
}
