package br.com.sonda_teste.aeronaveV2.api.dto.response;

import java.util.List;

public record AeronavesPorDecadaResponse(
        Integer decada,
        List<AeronaveResponse> aeronaves
) {
}
