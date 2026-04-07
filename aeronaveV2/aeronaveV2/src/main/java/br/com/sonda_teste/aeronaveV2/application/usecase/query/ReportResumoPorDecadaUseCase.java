package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.ReportPorDecadaQuery;
import br.com.sonda_teste.aeronaveV2.application.port.in.query.ReportResumoPorDecadaQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.DecadaSummary;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportResumoPorDecadaUseCase implements ReportResumoPorDecadaQuery {

    private final AeronaveRepository repository;

    @Override
    public List<DecadaSummary> execute() {

        return repository.summarizeByDecada();
    }
}
