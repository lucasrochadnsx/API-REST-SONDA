package br.com.sonda_teste.aeronaveV2.application.usecase.command;

import br.com.sonda_teste.aeronaveV2.application.port.in.command.UpdateAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.domain.exception.AeronaveNotFoundException;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UpdateAeronaveUseCase implements UpdateAeronaveCommand {


    private final AeronaveRepository repository;
    private final Clock clock;

    @Override
    public Aeronave execute(Long id, Consumer<Aeronave> mutator) {
        Aeronave existente = repository.findById(id)
                .orElseThrow(() -> new AeronaveNotFoundException(id));
        mutator.accept(existente);
        existente.setId(id);
        existente.setUpdatedAt(OffsetDateTime.now(clock));
        return repository.save(existente);
    }
}
