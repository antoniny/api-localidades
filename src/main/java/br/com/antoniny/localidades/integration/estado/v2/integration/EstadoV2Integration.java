package br.com.antoniny.localidades.integration.estado.v2.integration;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;
import br.com.antoniny.localidades.integration.estado.v1.exception.EstadoException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "ApiIBGEEstadoV2", url = "${api.v1.integracao.estados.url}")
public interface EstadoV2Integration {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<EstadoDto> getEstados() throws EstadoException;

}
