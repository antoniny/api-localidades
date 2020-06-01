package br.com.antoniny.localidades.service.dto;

import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;


public class MunicipioIdResponseDto {
    private int idCidade;

    public MunicipioIdResponseDto() {
    }

    public MunicipioIdResponseDto(int idCidade) {
        this.idCidade = idCidade;
    }

    public MunicipioIdResponseDto(MunicipioDto municipioDto) {
        this.idCidade = municipioDto.getId();
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
}
