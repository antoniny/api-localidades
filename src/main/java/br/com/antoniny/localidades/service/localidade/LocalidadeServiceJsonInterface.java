package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseJsonDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocalidadeServiceJsonInterface {

    ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJson();

    ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJsonV2();
}
