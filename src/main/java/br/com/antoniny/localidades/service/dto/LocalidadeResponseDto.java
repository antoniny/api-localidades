package br.com.antoniny.localidades.service.dto;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;
import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;

public class LocalidadeResponseDto extends LocalidadeDto {

    public LocalidadeResponseDto() {
        super();
    }

    public LocalidadeResponseDto(EstadoDto estadoDto, MunicipioDto municipioDto) {
        super();
        this.setIdEstado(estadoDto.getId());
        this.setSiglaEstado(estadoDto.getSigla());
        this.setRegiaoNome(estadoDto.getRegiao().getNome());
        this.setNomeCidade(municipioDto.getNome());
        this.setNomeMesorregiao(municipioDto.getMicrorregiao().getMesorregiao().getNome());
        this.setNomeFormatado(this.getNomeCidade()+"/"+this.getSiglaEstado());
    }
}
