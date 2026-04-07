package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.ReportPorDecadaQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReportPorDecadaUseCase implements ReportPorDecadaQuery {

    private final AeronaveRepository repository;

    @Override
    public Map<Integer, List<Aeronave>> execute() {
        return repository.findAllByOrderByAnoFabricacaoAsc()
                .stream()
                .collect(Collectors.groupingBy(
                        a -> (a.getAnoFabricacao() / 10) * 10,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
    }
}
