package br.com.antoniny.localidades.integration.municipio.v1.integration;


import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;
import br.com.antoniny.localidades.integration.municipio.v1.exception.MunicipioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MunicipioIntegration {

    @Value("${api.v1.integracao.municipios.url}")
    private String urlApiMunicipios;

    public List<MunicipioDto> getMunicipios(String uf) throws MunicipioException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity<MunicipioDto[]> response = restTemplate.exchange(
                urlApiMunicipios,
                HttpMethod.GET,
                request,
                MunicipioDto[].class,
                uf
        );

        return Arrays.stream(response.getBody()).collect(Collectors.toList());
    }

}