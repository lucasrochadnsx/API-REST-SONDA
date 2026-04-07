package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.SearchAeronavesPagedQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchAeronavesPagedUseCase implements SearchAeronavesPagedQuery {

    private final AeronaveRepository repository;

    @Override
    public Page<Aeronave> execute(String termo, Pageable pageable) {
        return repository.searchPaged(termo, pageable);
    }
}
