package br.com.antoniny.localidades.service.estado;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;

import java.util.List;

public interface EstadoServiceInterface {

    List<EstadoDto> getAllEstados();
}
