package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.ReportResumoPorFabricanteQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.FabricanteSummary;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportResumoPorFabricanteUseCase implements ReportResumoPorFabricanteQuery {

    private final AeronaveRepository repository;

    @Override
    public List<FabricanteSummary> execute() {

        return repository.summarizeByFabricante();
    }
}
