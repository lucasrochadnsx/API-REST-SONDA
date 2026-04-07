package br.com.sonda_teste.aeronaveV2.application.usecase.command;

import br.com.sonda_teste.aeronaveV2.application.port.in.command.CreateAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CreateAeronaveUseCase implements CreateAeronaveCommand {

    private final AeronaveRepository repository;
    private final Clock clock;

    @Override
    public Aeronave execute(Aeronave aeronave) {
        OffsetDateTime now = OffsetDateTime.now(clock);
        aeronave.setId(null);
        aeronave.setCreatedAt(now);
        aeronave.setUpdatedAt(now);
        if(aeronave.getVendido() == null) aeronave.setVendido(Boolean.FALSE);
        return repository.save(aeronave);
    }
}
