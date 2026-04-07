package br.com.sonda_teste.aeronaveV2.domain.exception;

public class AeronaveNotFoundException extends RuntimeException {
    public AeronaveNotFoundException(Long id) {

        super("Aeronave não encontrada: " + id);
    }
}
