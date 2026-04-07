package br.com.sonda_teste.aeronaveV2.infra.adapter;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.DecadaSummary;
import br.com.sonda_teste.aeronaveV2.domain.model.FabricanteSummary;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import br.com.sonda_teste.aeronaveV2.infra.entity.AeronaveEntity;
import br.com.sonda_teste.aeronaveV2.infra.mapper.AeronavePersistenceMapper;
import br.com.sonda_teste.aeronaveV2.infra.persistence.AeronaveDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AeronaveRepositoryAdapter implements AeronaveRepository {

    private final AeronaveDataRepository aeronaveRepository;
    private final AeronavePersistenceMapper mapper;

    @Override
    public Page<Aeronave> findAll(Pageable pageable) {
        return aeronaveRepository.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public Optional<Aeronave> findById(Long id) {

        return aeronaveRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Aeronave save(Aeronave aeronave) {
        AeronaveEntity saved = aeronaveRepository.save(mapper.toEntity(aeronave));
        return mapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        aeronaveRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
       return aeronaveRepository.existsById(id);
    }

    @Override
    public List<Aeronave> findByTermo(String termo) {
        return aeronaveRepository.findByTermo(termo).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Aeronave> findByVendidoFalse() {
        return aeronaveRepository.findByVendidoFalse().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Aeronave> findAllByOrderByAnoFabricacaoAsc() {
        return aeronaveRepository.findAllByOrderByAnoFabricacaoAsc().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Aeronave> findAllByOrderByFabricanteAsc() {
        return aeronaveRepository.findAllByOrderByFabricanteAsc().stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Aeronave> findRecent(OffsetDateTime data) {
        return aeronaveRepository.findRecent(data).stream().map(mapper::toDomain).toList();
    }


    @Override
    public List<DecadaSummary> summarizeByDecada() {
        return aeronaveRepository.countByDecade().stream()
                .map(p -> new DecadaSummary(p.getDecada(), p.getTotal()))
                .toList();
    }

    @Override
    public List<FabricanteSummary> summarizeByFabricante() {
        return aeronaveRepository.countByFabricante().stream()
                .map(p -> new FabricanteSummary(p.getFabricante(), p.getTotal()))
                .toList();
    }

    @Override
    public Page<Aeronave> searchPaged(String termo, Pageable pageable) {
        return aeronaveRepository.searchPaged(termo, pageable)
                .map(p -> {
                    Aeronave aeronave = new Aeronave();
                    aeronave.setId(p.getId());
                    aeronave.setNome(p.getNome());
                    aeronave.setFabricante(p.getFabricante());
                    aeronave.setAnoFabricacao(p.getAnoFabricacao());
                    aeronave.setDescricao(p.getDescricao());
                    aeronave.setVendido(Boolean.TRUE.equals(p.getVendido()));
                    aeronave.setCreatedAt(p.getCreatedAt());
                    aeronave.setUpdatedAt(p.getUpdatedAt());
                    return aeronave;
                });
    }
}
