package br.com.sonda_teste.aeronaveV2.api.exception;

import br.com.sonda_teste.aeronaveV2.api.exception.model.ApiErrorResponse;
import br.com.sonda_teste.aeronaveV2.api.exception.model.Violation;
import br.com.sonda_teste.aeronaveV2.domain.exception.AeronaveNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;

public class ExceptionApiHandler {

    @ExceptionHandler(AeronaveNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFound(AeronaveNotFoundException ex, HttpServletRequest request) {
        return build(HttpStatus.NOT_FOUND, "Resource not found", ex.getMessage(), request.getRequestURI(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<Violation> violations = ex.getBindingResult().getFieldErrors().stream()
                .map(this::toViolation)
                .toList();

        return build(HttpStatus.BAD_REQUEST, "Validation failed", "One or more fields are invalid.", request.getRequestURI(), violations);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleIntegrity(DataIntegrityViolationException ex, HttpServletRequest request) {
        return build(HttpStatus.CONFLICT, "Data integrity violation", "Operation violates a database constraint.", request.getRequestURI(), null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(Exception ex, HttpServletRequest request) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", "An unexpected error occurred.", request.getRequestURI(), null);
    }

    private ResponseEntity<ApiErrorResponse> build(HttpStatus status, String error, String message, String path, List<Violation> violations) {
        ApiErrorResponse body = new ApiErrorResponse(
                OffsetDateTime.now(),
                status.value(),
                error,
                message,
                path,
                violations
        );
        return ResponseEntity.status(status).body(body);
    }

    private Violation toViolation(FieldError fe) {
        return new Violation(fe.getField(), fe.getDefaultMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> generic(Exception ex, HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ApiErrorResponse(
                        OffsetDateTime.now(),
                        HttpStatus.NOT_FOUND.value(),
                        "Internal Server Error",
                        "Erro inesperado",
                        req.getRequestURI(),
                        List.of()
                )
        );
    }
}
