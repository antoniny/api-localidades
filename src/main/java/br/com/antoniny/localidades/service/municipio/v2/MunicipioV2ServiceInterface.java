package br.com.antoniny.localidades.service.municipio.v2;

import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;
import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MunicipioV2ServiceInterface {

    List<MunicipioDto> getMunicipiosUf(String uf);

    List<MunicipioDto> getAllMunicipios();

    ResponseEntity<List<MunicipioIdResponseDto>> findIdMunicipioByName (String nomeMunicipio);
}
