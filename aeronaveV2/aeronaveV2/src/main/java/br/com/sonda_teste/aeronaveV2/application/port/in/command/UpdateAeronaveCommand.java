package br.com.sonda_teste.aeronaveV2.application.port.in.command;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

import java.util.function.Consumer;

public interface UpdateAeronaveCommand {

    Aeronave execute(Long id, Consumer<Aeronave> mutator);
}
