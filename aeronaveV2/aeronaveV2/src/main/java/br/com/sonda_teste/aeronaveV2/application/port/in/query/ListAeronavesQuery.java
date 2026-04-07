package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



/*
*  Porta de entrada - lista paginada de Aeronaves
* */
public interface ListAeronavesQuery {

    Page<Aeronave> execute(Pageable pageable);
}
