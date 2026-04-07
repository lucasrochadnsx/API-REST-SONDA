package br.com.sonda_teste.aeronaveV2.application.port.in.command;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

import java.util.function.Consumer;
/*
* Porta de entrada (Command) para atualização parcial da Aeronave
* */
public interface PatchAeronaveCommand {

    Aeronave execute(Long id, Consumer<Aeronave> patcher);
}
