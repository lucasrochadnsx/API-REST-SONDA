package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.FindNaoVendidasQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindNaoVendidasUseCase implements FindNaoVendidasQuery {

    private final AeronaveRepository repository;

    @Override
    public List<Aeronave> execute() {
        return repository.findByVendidoFalse();
    }
}
