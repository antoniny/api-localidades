package br.com.antoniny.localidades.integration.municipio.v2;

import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;
import br.com.antoniny.localidades.integration.municipio.v1.exception.MunicipioException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(value = "ApiIBGEMunicipioV2", url = "${api.v2.integracao.municipios.url}")
public interface MunicipioV2Integration {


    @GetMapping(value = "${api.v2.integracao.municipios.uf.path}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<MunicipioDto> getMunicipios(@PathVariable String uf) throws MunicipioException;

}
