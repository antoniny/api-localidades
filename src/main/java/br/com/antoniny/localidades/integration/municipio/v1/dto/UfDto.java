package br.com.antoniny.localidades.integration.municipio.v1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UfDto extends Municipio {

    private String sigla;
    private RegiaoDto regiao;

    public UfDto() {

    }

}
