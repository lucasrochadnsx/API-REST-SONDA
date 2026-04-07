package br.com.sonda_teste.aeronaveV2.api.controller;

import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveCreateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronavePatchRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.request.AeronaveUpdateRequest;
import br.com.sonda_teste.aeronaveV2.api.dto.response.*;
import br.com.sonda_teste.aeronaveV2.api.mapper.AeronaveApiMapper;
import br.com.sonda_teste.aeronaveV2.application.port.in.command.CreateAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.application.port.in.command.DeleteAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.application.port.in.command.PatchAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.application.port.in.command.UpdateAeronaveCommand;
import br.com.sonda_teste.aeronaveV2.application.port.in.query.*;
import br.com.sonda_teste.aeronaveV2.domain.model.Aeronave;
import br.com.sonda_teste.aeronaveV2.domain.model.Fabricante;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/aeronaves")
@RequiredArgsConstructor
public class AeronaveController {

    private final AeronaveApiMapper apiMapper;
    private final ListAeronavesQuery listAeronaves;
    private final SearchAeronavesPagedQuery searchAeronavesPaged;
    private final SearchAeronaveQuery searchAeronave;
    private final GetAeronaveByIdQuery getById;
    private final FindNaoVendidasQuery findNaoVendidas;
    private final FindRecentAeronavesQuery findRecent;
    private final CreateAeronaveCommand create;
    private final UpdateAeronaveCommand updatedById;
    private final PatchAeronaveCommand patch;
    private final DeleteAeronaveCommand delete;
    private final ReportPorDecadaQuery reportPorDecada;
    private final ReportPorFabricanteQuery reportPorFabricante;
    private final ReportResumoPorFabricanteQuery reportResumoPorFabricante;
    private final ReportResumoPorDecadaQuery reportResumoPorDecada;

    @GetMapping
    public ResponseEntity<Page<AeronaveResponse>> findAll(@PageableDefault(size = 12) Pageable pageable) {
        Page<AeronaveResponse> page = listAeronaves.execute(pageable).map(apiMapper::toResponse);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/find")
    public ResponseEntity<List<AeronaveResponse>> find(@RequestParam String termo) {
        List<AeronaveResponse> list = searchAeronave.execute(termo).stream().map(apiMapper::toResponse).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AeronaveResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(apiMapper.toResponse(getById.execute(id)));
    }

    @GetMapping("/find/paged")
    public ResponseEntity<Page<AeronaveResponse>> findPaged(@RequestParam String termo, @PageableDefault(size = 12) Pageable pageable) {
        Page<AeronaveResponse> page = searchAeronavesPaged.execute(termo, pageable).map(apiMapper::toResponse);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/nao-vendidas")
    public ResponseEntity<List<AeronaveResponse>> findByVendidoFalse() {
        return ResponseEntity.ok(findNaoVendidas.execute().stream().map(apiMapper::toResponse).toList());
    }

    @GetMapping("/ultima-semana")
    public ResponseEntity<List<AeronaveResponse>> findRecent() {
        return ResponseEntity.ok(findRecent.execute().stream().map(apiMapper::toResponse).toList());

    }

    @GetMapping("/por-decada")
    public ResponseEntity<List<AeronavesPorDecadaResponse>> porDecada() {
        Map<Integer, List<Aeronave>> grouped = reportPorDecada.execute();
        List<AeronavesPorDecadaResponse> resp = grouped.entrySet().stream()
                .map(e -> new AeronavesPorDecadaResponse(
                        e.getKey(),
                        e.getValue().stream().map(apiMapper::toResponse).toList()
                ))
                .toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/por-decada/resumo")
    public ResponseEntity<List<AeronavesPorDecadaResumoResponse>> porDecadaResumo() {
        var resp = reportResumoPorDecada.execute().stream()
                .map(s -> new AeronavesPorDecadaResumoResponse(s.decada(), s.total()))
                .toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/por-fabricante")
    public ResponseEntity<List<AeronavesPorFabricanteResponse>> porFabricante() {
        Map<Fabricante, List<Aeronave>> grouped = reportPorFabricante.execute();
        List<AeronavesPorFabricanteResponse> resp = grouped.entrySet().stream()
                .map(e -> new AeronavesPorFabricanteResponse(
                        e.getKey(),
                        e.getValue().stream().map(apiMapper::toResponse).toList()
                ))
                .toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/por-fabricante/resumo")
    public ResponseEntity<List<AeronavesPorFabricanteResumoResponse>> porFabricanteResumo() {
        var resp = reportResumoPorFabricante.execute().stream()
                .map(s -> new AeronavesPorFabricanteResumoResponse(s.fabricante(), s.total()))
                .toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<AeronaveResponse> save(@Valid @RequestBody AeronaveCreateRequest request) {
        Aeronave created = create.execute(apiMapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(apiMapper.toResponse(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AeronaveResponse> updateById(@PathVariable Long id, @Valid @RequestBody AeronaveUpdateRequest request) {
        Aeronave updated = updatedById.execute(id, existing -> apiMapper.updateDomain(request, existing));
        return ResponseEntity.ok(apiMapper.toResponse(updated));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AeronaveResponse> patch(@PathVariable Long id, @Valid @RequestBody AeronavePatchRequest request) {
        Aeronave patched = patch.execute(id, a -> {
            if (request.nome() != null) a.setNome(request.nome());
            if (request.fabricante() != null) a.setFabricante(request.fabricante());
            if (request.anoFabricacao() != null) a.setAnoFabricacao(request.anoFabricacao());
            if (request.descricao() != null) a.setDescricao(request.descricao());
            if (request.vendido() != null) a.setVendido(request.vendido());
        });
        return ResponseEntity.ok(apiMapper.toResponse(patched));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        delete.execute(id);
    }
}
