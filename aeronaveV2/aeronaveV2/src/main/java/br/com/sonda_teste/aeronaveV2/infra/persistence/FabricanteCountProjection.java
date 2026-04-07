package br.com.sonda_teste.aeronaveV2.infra.persistence;

import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;

/*
*  Projeção read model de década
* */
public interface FabricanteCountProjection {

    Fabricante getFabricante();

    Long getTotal();
}
