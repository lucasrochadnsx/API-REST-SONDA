package br.com.sonda_teste.aeronaveV2.api.exception.model;

import java.time.OffsetDateTime;
import java.util.List;

public record ApiErrorResponse(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        List<Violation> violations
) {
}
