package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseDto;

import java.util.List;

public interface LocalidadeServiceInterface {

    List<LocalidadeResponseDto> getAllLocalidades();
}
