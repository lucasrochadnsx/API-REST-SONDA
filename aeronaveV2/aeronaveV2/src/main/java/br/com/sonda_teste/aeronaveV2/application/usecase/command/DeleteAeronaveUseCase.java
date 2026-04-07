package br.com.sonda_teste.aeronaveV2.application.usecase.command;

import br.com.sonda_teste.aeronaveV2.application.port.in.command.DeleteAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.domain.exception.AeronaveNotFoundException;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAeronaveUseCase implements DeleteAeronaveCommand {

    private final AeronaveRepository repository;

    @Override
    public void execute(Long id) {
        if (!repository.existsById(id)) throw new AeronaveNotFoundException(id);
        repository.deleteById(id);
    }
}
