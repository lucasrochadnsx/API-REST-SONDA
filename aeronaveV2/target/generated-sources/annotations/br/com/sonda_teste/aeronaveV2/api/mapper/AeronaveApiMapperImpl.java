package br.com.sonda_teste.aeronaveV2.api.mapper;

import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveCreateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveUpdateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.response.AeronaveResponse;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import java.time.OffsetDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-06T21:49:10-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class AeronaveApiMapperImpl implements AeronaveApiMapper {

    @Override
    public Aeronave toDomain(AeronaveCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Aeronave.AeronaveBuilder aeronave = Aeronave.builder();

        aeronave.nome( request.nome() );
        aeronave.fabricante( request.fabricante() );
        aeronave.anoFabricacao( request.anoFabricacao() );
        aeronave.descricao( request.descricao() );
        aeronave.vendido( request.vendido() );

        return aeronave.build();
    }

    @Override
    public void updateDomain(AeronaveUpdateRequest request, Aeronave target) {
        if ( request == null ) {
            return;
        }

        if ( request.nome() != null ) {
            target.setNome( request.nome() );
        }
        if ( request.fabricante() != null ) {
            target.setFabricante( request.fabricante() );
        }
        if ( request.anoFabricacao() != null ) {
            target.setAnoFabricacao( request.anoFabricacao() );
        }
        if ( request.descricao() != null ) {
            target.setDescricao( request.descricao() );
        }
        if ( request.vendido() != null ) {
            target.setVendido( request.vendido() );
        }
    }

    @Override
    public AeronaveResponse toResponse(Aeronave domain) {
        if ( domain == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        Fabricante fabricante = null;
        Integer anoFabricacao = null;
        String descricao = null;
        Boolean vendido = null;
        OffsetDateTime createdAt = null;
        OffsetDateTime updatedAt = null;

        id = domain.getId();
        nome = domain.getNome();
        fabricante = domain.getFabricante();
        anoFabricacao = domain.getAnoFabricacao();
        descricao = domain.getDescricao();
        vendido = domain.getVendido();
        createdAt = domain.getCreatedAt();
        updatedAt = domain.getUpdatedAt();

        AeronaveResponse aeronaveResponse = new AeronaveResponse( id, nome, fabricante, anoFabricacao, descricao, vendido, createdAt, updatedAt );

        return aeronaveResponse;
    }
}
