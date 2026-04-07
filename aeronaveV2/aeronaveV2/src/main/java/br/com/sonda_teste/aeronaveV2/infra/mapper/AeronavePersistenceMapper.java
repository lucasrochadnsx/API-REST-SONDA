package br.com.sonda_teste.aeronaveV2.infra.mapper;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.infra.entity.AeronaveEntity;
import org.springframework.stereotype.Component;

@Component
public class AeronavePersistenceMapper {

    public Aeronave toDomain(AeronaveEntity e) {
        if (e == null) return null;
        return Aeronave.builder()
                .id(e.getId())
                .nome(e.getNome())
                .fabricante(e.getFabricante())
                .anoFabricacao(e.getAnoFabricacao())
                .descricao(e.getDescricao())
                .vendido(e.getVendido())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }

    public AeronaveEntity toEntity(Aeronave d) {
        if (d == null) return null;
        return AeronaveEntity.builder()
                .id(d.getId())
                .nome(d.getNome())
                .fabricante(d.getFabricante())
                .anoFabricacao(d.getAnoFabricacao())
                .descricao(d.getDescricao())
                .vendido(d.getVendido())
                .createdAt(d.getCreatedAt())
                .updatedAt(d.getUpdatedAt())
                .build();
    }

    public void mergeIntoEntity(Aeronave source, AeronaveEntity target) {
        if (source.getNome() != null) target.setNome(source.getNome());
        if (source.getFabricante() != null) target.setFabricante(source.getFabricante());
        if (source.getAnoFabricacao() != null) target.setAnoFabricacao(source.getAnoFabricacao());
        if (source.getDescricao() != null) target.setDescricao(source.getDescricao());
        if (source.getVendido() != null) target.setVendido(source.getVendido());
        if (source.getCreatedAt() != null) target.setCreatedAt(source.getCreatedAt());
        if (source.getUpdatedAt() != null) target.setUpdatedAt(source.getUpdatedAt());
    }
}
