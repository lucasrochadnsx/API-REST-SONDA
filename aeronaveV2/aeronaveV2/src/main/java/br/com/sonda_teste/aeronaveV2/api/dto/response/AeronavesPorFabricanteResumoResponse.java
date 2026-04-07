package br.com.sonda_teste.aeronaveV2.api.dto.response;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

public record AeronavesPorFabricanteResumoResponse(
        Fabricante fabricante, long total
) {
}
