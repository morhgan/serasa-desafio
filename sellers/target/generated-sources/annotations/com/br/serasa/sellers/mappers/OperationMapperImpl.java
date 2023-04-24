package com.br.serasa.sellers.mappers;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.OperationDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T12:18:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class OperationMapperImpl implements OperationMapper {

    @Override
    public Operation dtoToEntity(OperationDto request) {
        if ( request == null ) {
            return null;
        }

        Operation.OperationBuilder operation = Operation.builder();

        operation.region( request.getRegion() );
        List<String> list = request.getStates();
        if ( list != null ) {
            operation.states( new ArrayList<String>( list ) );
        }

        return operation.build();
    }
}
