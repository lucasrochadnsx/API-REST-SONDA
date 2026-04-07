package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.DecadaSummary;

import java.util.List;

public interface ReportResumoPorDecadaQuery {

    List<DecadaSummary> execute();
}
