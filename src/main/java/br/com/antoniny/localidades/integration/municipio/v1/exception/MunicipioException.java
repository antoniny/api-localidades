package br.com.antoniny.localidades.integration.municipio.v1.exception;

public class MunicipioException extends RuntimeException{

    public MunicipioException(String message) {
            super(message);
        }

    public MunicipioException(String message, Exception cause) {
            super(message, cause);
        }
}
