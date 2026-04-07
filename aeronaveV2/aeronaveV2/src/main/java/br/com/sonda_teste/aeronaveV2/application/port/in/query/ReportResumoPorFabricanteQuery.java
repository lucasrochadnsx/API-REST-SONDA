package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.FabricanteSummary;

import java.util.List;

public interface ReportResumoPorFabricanteQuery {

    List<FabricanteSummary> execute();
}
