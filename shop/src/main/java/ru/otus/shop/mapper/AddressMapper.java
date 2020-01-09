package ru.otus.shop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.otus.shop.db.entity.Address;
import ru.otus.shop.dto.AddressDto;
import ru.otus.shop.web.request.address.AddressCreateRequest;

import java.util.Objects;

@Component
public class AddressMapper extends AbstractSMapper<Address, AddressDto> {
    protected AddressMapper(ModelMapper mapper) {
        super(mapper, Address.class, AddressDto.class);
    }

    public Address toEntity(AddressCreateRequest request) {
        return Objects.isNull(request) ? null : mapper.map(request, Address.class);
    }
}
