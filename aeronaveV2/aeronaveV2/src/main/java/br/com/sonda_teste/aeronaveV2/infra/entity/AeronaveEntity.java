package br.com.sonda_teste.aeronaveV2.infra.entity;


import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Entity
@Table(name = "aeronaves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AeronaveEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Fabricante fabricante;

    @Column(nullable = false)
    private Integer anoFabricacao;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Boolean vendido;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @PrePersist
    void prePersist() {
        OffsetDateTime now = OffsetDateTime.now();
        if (createdAt == null) createdAt = now;
        if (updatedAt == null) updatedAt = now;
        if (vendido == null) vendido = Boolean.FALSE;
    }

    @PreUpdate
    void preUpdate() {
        updatedAt = OffsetDateTime.now();
    }
}

