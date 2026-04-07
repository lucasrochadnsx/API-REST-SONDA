package br.com.sonda_teste.aeronaveV2.api.dto.response;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

import java.util.List;

public record AeronavesPorFabricanteResponse(
        Fabricante fabricante,
        List<AeronaveResponse> aeronaves
) {
}
