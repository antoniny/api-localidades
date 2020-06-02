package br.com.antoniny.localidades.integration.estado.v1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class EstadoDto extends Estado {

    private RegiaoDto regiao;

    public EstadoDto() {
    }

}
