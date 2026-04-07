package br.com.sonda_teste.aeronaveV2.api.dto.response;

public record AeronavesPorDecadaResumoResponse(
        Long decada,
        Long total
) {
}
