package br.com.sonda_teste.aeronaveV2.domain.repository;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.DecadaSummary;
import br.com.sonda_teste.aeronaveV2.domain.model.FabricanteSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

/*
*  Porta de OUT do core para camada de persistence
*  Implementações delegadas para camada de Infra
* */
public interface AeronaveRepository {

    Page<Aeronave> findAll(Pageable pageable);

    Optional<Aeronave> findById(Long id);

    Aeronave save(Aeronave aeronave);

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Aeronave> findByTermo(String termo);

    List<Aeronave> findByVendidoFalse();

    List<Aeronave> findAllByOrderByAnoFabricacaoAsc();

    List<Aeronave> findAllByOrderByFabricanteAsc();

    List<Aeronave> findRecent(OffsetDateTime data);

    List<DecadaSummary> summarizeByDecada();

    List<FabricanteSummary> summarizeByFabricante();

    default List<Aeronave> findAllList() {
        return findAll(Pageable.unpaged()).getContent();
    }

    Page<Aeronave> searchPaged(String termo, Pageable pageable);
}
