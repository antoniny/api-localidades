package br.com.antoniny.localidades.integration.estado.v1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Estado {

    private int id;
    private String nome;
    private String sigla;

    public Estado() {
    }

}
