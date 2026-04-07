package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.SearchAeronaveQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchAeronaveUseCase implements SearchAeronaveQuery {

    private final AeronaveRepository repository;

    public List<Aeronave> execute(String termo) {
        return repository.findByTermo(termo);
    }
}
