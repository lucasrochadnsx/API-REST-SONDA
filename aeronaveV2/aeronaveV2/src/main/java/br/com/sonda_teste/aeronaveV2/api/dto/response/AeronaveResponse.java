package br.com.sonda_teste.aeronaveV2.api.dto.response;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

import java.time.OffsetDateTime;

public record AeronaveResponse(
        Long id,
        String nome,
        Fabricante fabricante,
        Integer anoFabricacao,
        String descricao,
        Boolean vendido,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt
) {
}
