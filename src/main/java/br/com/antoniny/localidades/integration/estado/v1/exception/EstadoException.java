package br.com.antoniny.localidades.integration.estado.v1.exception;

public class EstadoException extends RuntimeException {

        public EstadoException(String message) {
            super(message);
        }

        public EstadoException(String message, Exception cause) {
            super(message, cause);
        }

}
