package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.GetAeronaveByIdQuery;
import br.com.sonda_teste.aeronaveV2.domain.exception.AeronaveNotFoundException;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAeronaveByIdUseCase implements GetAeronaveByIdQuery {

    private final AeronaveRepository repository;

    @Override
    public Aeronave execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new AeronaveNotFoundException(id));
    }
}
