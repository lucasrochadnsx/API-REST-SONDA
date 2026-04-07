package br.com.sonda_teste.aeronaveV2.application.port.in.command;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

/*
* Porta de entrada (Command) cria um Aeronave
* */
public interface CreateAeronaveCommand {

    Aeronave execute(Aeronave aeronave);
}
