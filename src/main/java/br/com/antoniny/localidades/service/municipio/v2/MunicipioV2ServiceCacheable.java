package br.com.antoniny.localidades.service.municipio.v2;

import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import br.com.antoniny.localidades.service.municipio.v1.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("municipiosV2MethodsCacheable")
public class MunicipioV2ServiceCacheable {

    @Autowired
    private MunicipioV2Service municipioService;

    @Cacheable("nomeMunicipioV2")
    public ResponseEntity<List<MunicipioIdResponseDto>> findByName (String nomeMunicipio) {
        List<MunicipioIdResponseDto> municipios = municipioService.getAllMunicipios()
                .stream()
                .filter(municipioDto -> municipioDto
                        .getNome()
                        .toUpperCase()
                        .equals(nomeMunicipio.toUpperCase()))
                .map(MunicipioIdResponseDto::new)
                .collect(Collectors.toList());

        return municipios.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(new MunicipioIdResponseDto()))
                : ResponseEntity.ok().body(municipios);
    }
}
