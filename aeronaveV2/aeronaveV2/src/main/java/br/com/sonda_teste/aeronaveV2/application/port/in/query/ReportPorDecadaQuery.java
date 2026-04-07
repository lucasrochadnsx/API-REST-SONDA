package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;

import java.util.List;
import java.util.Map;

/*
*  Porta de entrada - relatorio agrupado por década
* */
public interface ReportPorDecadaQuery {
    Map<Integer, List<Aeronave>> execute();
}
