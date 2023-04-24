package com.br.serasa.sellers.mappers;

import com.br.serasa.sellers.models.Operation;
import com.br.serasa.sellers.models.Seller;
import com.br.serasa.sellers.models.SellerDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-24T12:20:18-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class SellerMapperImpl implements SellerMapper {

    @Override
    public Seller dtoToEntity(SellerDto request) {
        if ( request == null ) {
            return null;
        }

        Seller.SellerBuilder seller = Seller.builder();

        seller.name( request.getName() );
        seller.phone( request.getPhone() );
        if ( request.getAge() != null ) {
            seller.age( Long.parseLong( request.getAge() ) );
        }
        seller.city( request.getCity() );
        seller.state( request.getState() );

        seller.inclusionDate( java.time.LocalDate.now() );
        seller.operation( mapOperation(request.getRegion()) );

        return seller.build();
    }

    @Override
    public Operation mapOperation(String value) {
        if ( value == null ) {
            return null;
        }

        Operation.OperationBuilder operation = Operation.builder();

        operation.region( value );

        return operation.build();
    }
}
