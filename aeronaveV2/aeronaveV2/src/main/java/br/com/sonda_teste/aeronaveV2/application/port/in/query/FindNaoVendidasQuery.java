package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

import java.util.List;

/*
*  Porta de entrada - Aeronaves não vendidas
* */
public interface FindNaoVendidasQuery {
    List<Aeronave> execute();
}
