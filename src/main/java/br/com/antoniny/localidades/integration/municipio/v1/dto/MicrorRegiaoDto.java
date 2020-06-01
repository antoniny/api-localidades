package br.com.antoniny.localidades.integration.municipio.v1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MicrorRegiaoDto extends Municipio {

    private MesorRegiaoDto mesorregiao;

    public MicrorRegiaoDto() {

    }

}
