package ru.otus.shop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import ru.otus.shop.db.entity.SEntity;
import ru.otus.shop.dto.SDto;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractSMapper<DOC extends SEntity, DTO extends SDto> implements SMapper<DOC, DTO> {

    protected ModelMapper mapper;

    private Class<DOC> documentType;

    private Class<DTO> dtoType;

    protected AbstractSMapper(ModelMapper mapper, Class<DOC> documentType, Class<DTO> dtoType) {
        this.mapper = mapper;
        this.documentType = documentType;
        this.dtoType = dtoType;
    }

    @Override
    public DOC toDocument(DTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, documentType);
    }

    @Override
    public DTO toDto(DOC document) {
        return Objects.isNull(document) ? null : mapper.map(document, dtoType);
    }

    @Override
    public List<DTO> createDTOs(Collection<DOC> documents) {
        return documents.stream().map(document -> mapper.map(document, dtoType)).collect(Collectors.toList());
    }

    @Override
    public Page<DTO> createDTOs(Page<DOC> documents) {
        return documents.map(this::toDto);
    }

}

