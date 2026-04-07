package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.ListAeronavesQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ListAeronavesUseCase implements ListAeronavesQuery {

    private final AeronaveRepository repository;

    @Override
    public Page<Aeronave> execute(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
