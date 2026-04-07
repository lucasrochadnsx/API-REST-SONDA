package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

/*
*  Porta de entrada - obtém Aeronave por ID
* */
public interface GetAeronaveByIdQuery {

    Aeronave execute(Long id);
}
