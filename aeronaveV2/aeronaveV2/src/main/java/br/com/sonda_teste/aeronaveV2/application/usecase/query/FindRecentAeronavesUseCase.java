package br.com.sonda_teste.aeronaveV2.application.usecase.query;

import br.com.sonda_teste.aeronaveV2.application.port.in.query.FindRecentAeronavesQuery;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.repository.AeronaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindRecentAeronavesUseCase implements FindRecentAeronavesQuery {

    private final AeronaveRepository repository;
    private final Clock clock;

    @Override
    public List<Aeronave> execute() {
        OffsetDateTime after = OffsetDateTime.now(clock).minusDays(7);
        return repository.findRecent(after);
    }
}
