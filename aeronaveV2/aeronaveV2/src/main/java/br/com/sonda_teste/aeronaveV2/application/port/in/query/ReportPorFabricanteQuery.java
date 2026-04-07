package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

import java.util.List;
import java.util.Map;

/*
* Porta de Entrada - relatório por fabricante
* */
public interface ReportPorFabricanteQuery {
    Map<Fabricante, List<Aeronave>> execute();
}
