package br.com.sonda_teste.aeronaveV2.api.mapper;

import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveCreateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveUpdateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.response.AeronaveResponse;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AeronaveApiMapper {

    Aeronave toDomain(AeronaveCreateRequest request);

    void updateDomain(AeronaveUpdateRequest request, @MappingTarget Aeronave target);

    AeronaveResponse toResponse(Aeronave domain);
}