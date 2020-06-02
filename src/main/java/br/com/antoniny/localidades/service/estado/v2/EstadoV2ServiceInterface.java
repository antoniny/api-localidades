package br.com.antoniny.localidades.service.estado.v2;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;

import java.util.List;

public interface EstadoV2ServiceInterface {

    List<EstadoDto> getAllEstados();

}
