package br.com.sonda_teste.aeronaveV2.api.dto.request;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import jakarta.validation.constraints.*;

/** DTO de entrada para atualização completa.*/

public record AeronaveUpdateRequest(
        @NotBlank @Size(max = 150) String nome,
        @NotNull Fabricante fabricante,
        @NotNull @Min(1900) @Max(2100) Integer anoFabricacao,
        @NotBlank @Size(max = 255) String descricao,
        @NotNull Boolean vendido
) {
}
