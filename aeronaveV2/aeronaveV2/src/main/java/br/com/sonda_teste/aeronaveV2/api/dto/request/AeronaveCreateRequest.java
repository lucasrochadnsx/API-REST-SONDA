package br.com.sonda_teste.aeronaveV2.api.dto.request;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** DTO de entrada para criação.. */

public record AeronaveCreateRequest(
        @NotBlank @Size(max = 150) String nome,
        @NotNull Fabricante fabricante,
        @NotNull @Min(1900) @Max(2100) Integer anoFabricacao,
        @NotBlank @Size(max = 255) String descricao,
        Boolean vendido
) {
}
