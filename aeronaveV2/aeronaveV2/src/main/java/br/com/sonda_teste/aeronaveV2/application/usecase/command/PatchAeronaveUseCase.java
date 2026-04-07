package br.com.sonda_teste.aeronaveV2.application.usecase.command;

import br.com.sonda_teste.aeronaveV2.application.port.in.command.PatchAeronaveCommand;
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
public class PatchAeronaveUseCase implements PatchAeronaveCommand {

    private final AeronaveRepository repository;
    private final Clock clock;

    @Override
    public Aeronave execute(Long id, Consumer<Aeronave> patcher) {
        Aeronave aeronave = repository.findById(id)
                .orElseThrow(() -> new AeronaveNotFoundException(id));
        patcher.accept(aeronave);
        aeronave.setUpdatedAt(OffsetDateTime.now(clock));
        aeronave.setId(id);
        return repository.save(aeronave);
    }
}
