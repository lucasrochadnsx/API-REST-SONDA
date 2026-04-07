package br.com.sonda_teste.aeronaveV2.application.port.in.query;

import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchAeronavesPagedQuery {
    Page<Aeronave> execute(String termo, Pageable pageable);
}
