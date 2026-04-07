package br.com.sonda_teste.aeronaveV2.infra.persistence;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

import java.time.OffsetDateTime;

public interface AeronaveListItemProjection {

    Long getId();
    String getNome();
    Fabricante getFabricante();
    Integer getAnoFabricacao();
    String getDescricao();
    Boolean getVendido();
    OffsetDateTime getCreatedAt();
    OffsetDateTime getUpdatedAt();
}
