package br.com.antoniny.localidades.integration.municipio.v1.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
abstract class Municipio {
    private int id;
    private String nome;

}
