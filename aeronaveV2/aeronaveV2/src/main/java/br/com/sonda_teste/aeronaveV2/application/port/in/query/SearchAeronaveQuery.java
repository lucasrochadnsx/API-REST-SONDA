package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

import java.util.List;

/*Porta de entrada busca por termo */
public interface SearchAeronaveQuery {
    List<Aeronave> execute(String termo);
}
