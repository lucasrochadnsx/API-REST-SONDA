package br.com.sonda_teste.aeronaveV2.api.dto.request;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;


/* DTO ENTRADA (PATCH) para atualização parcial */
public record AeronavePatchRequest(
        @Size(max = 150) String nome,
        Fabricante fabricante,
        @Min(1900) @Max(2100) Integer anoFabricacao,
        @Size(max = 255) String descricao,
        Boolean vendido
) {
}
