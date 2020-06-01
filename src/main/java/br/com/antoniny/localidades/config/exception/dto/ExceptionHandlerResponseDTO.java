package br.com.antoniny.localidades.config.exception.dto;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;



public class ExceptionHandlerResponseDTO {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ExceptionHandlerResponseDTO(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ExceptionHandlerResponseDTO(HttpStatus status, String message, String error) {
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}
