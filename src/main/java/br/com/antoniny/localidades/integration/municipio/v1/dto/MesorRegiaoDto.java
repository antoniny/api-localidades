package br.com.antoniny.localidades.integration.municipio.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MesorRegiaoDto extends Municipio {

    @JsonProperty("UF")
    private UfDto uf;

    public MesorRegiaoDto() {

    }

}
