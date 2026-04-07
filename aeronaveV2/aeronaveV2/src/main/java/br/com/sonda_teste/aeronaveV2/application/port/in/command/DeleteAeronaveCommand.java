package br.com.sonda_teste.aeronaveV2.application.port.in.command;

/*
*  Porta de entrada(Command) - remove Aeronave
* */
public interface DeleteAeronaveCommand {

    void execute(Long id);
}
