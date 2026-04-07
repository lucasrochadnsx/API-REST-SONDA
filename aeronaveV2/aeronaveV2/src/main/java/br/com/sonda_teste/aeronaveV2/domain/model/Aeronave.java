package br.com.sonda_teste.aeronaveV2.domain.model;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aeronave {

    private Long id;
    private String nome;
    private Fabricante fabricante;
    private Integer anoFabricacao;
    private String descricao;
    private Boolean vendido;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}