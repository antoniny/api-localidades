package br.com.antoniny.localidades.config.exception;

import br.com.antoniny.localidades.config.exception.dto.ExceptionHandlerResponseDTO;
import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ NullPointerException.class })
    public ResponseEntity<ExceptionHandlerResponseDTO> handleNullPointerException(NullPointerException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

         String mensagem = "Ocorreu uma falha no processamento de sua requisição.";
         String erro = "["+ex.getClass()+"] "+ ex.getMessage();

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, mensagem , erro);

        return new ResponseEntity(handlerResponseDTO , HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({ ConnectException.class })
    public ResponseEntity<ExceptionHandlerResponseDTO> handleConnectException(ConnectException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagem = "Ocorreu uma falha de conexão durante o processamento de sua requisição.";
        String erro = "["+ex.getClass()+"] "+ ex.getMessage();

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, mensagem , erro);

        return new ResponseEntity(handlerResponseDTO , HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({ IllegalStateException.class })
    public ResponseEntity<ExceptionHandlerResponseDTO> handleIllegalStateException(IllegalStateException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagem = "Ocorreu uma falha no processamento de sua requisição.";
        String erro = "["+ex.getClass()+"] "+ ex.getMessage();

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, mensagem , erro);

        return new ResponseEntity(handlerResponseDTO , HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler({ FeignException.class })
    public ResponseEntity<ExceptionHandlerResponseDTO> handleFeignException(IllegalStateException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String mensagem = "Ocorreu uma falha no processamento de sua requisição.";
        String erro = "["+ex.getClass()+"] "+ ex.getMessage();

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, mensagem , erro);

        return new ResponseEntity(handlerResponseDTO , HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parâmetro é obrigatório.";

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(handlerResponseDTO, new HttpHeaders(), handlerResponseDTO.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {String fieldName = ((FieldError) error).getField();
                                                                 String errorMessage = error.getDefaultMessage();
                                                                 errors.add(fieldName +" -> "+ errorMessage);
                                                                });

        ExceptionHandlerResponseDTO handlerResponseDTO = new ExceptionHandlerResponseDTO(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<Object>(handlerResponseDTO, new HttpHeaders(), handlerResponseDTO.getStatus());
    }




}
