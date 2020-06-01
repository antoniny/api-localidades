package br.com.antoniny.localidades.integration.estado.v1.integration;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;
import br.com.antoniny.localidades.integration.estado.v1.exception.EstadoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoIntegration {

    @Value("${api.v1.integracao.estados.url}")
    private String urlApiEstado;

    public List<EstadoDto> getEstados() throws EstadoException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<EstadoDto[]> response = restTemplate.exchange(   urlApiEstado,
                                                                        HttpMethod.GET,
                                                                        request,
                                                                        EstadoDto[].class
                                                                    );

        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

}
