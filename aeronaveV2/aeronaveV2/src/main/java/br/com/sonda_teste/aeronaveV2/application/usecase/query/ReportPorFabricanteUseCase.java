package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.ReportPorFabricanteQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportPorFabricanteUseCase implements ReportPorFabricanteQuery {

    private final AeronaveRepository repository;

    @Override
    public Map<Fabricante, List<Aeronave>> execute() {
        return repository.findAllByOrderByFabricanteAsc()
                .stream()
                .collect(Collectors.groupingBy(
                        Aeronave::getFabricante,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }
}
