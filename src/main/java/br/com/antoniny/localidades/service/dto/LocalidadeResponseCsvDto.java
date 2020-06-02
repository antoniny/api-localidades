package br.com.antoniny.localidades.service.dto;

public class LocalidadeResponseCsvDto extends LocalidadeDto {

    public LocalidadeResponseCsvDto() {
        super();
    }

    public LocalidadeResponseCsvDto(LocalidadeResponseDto localidades) {
        super();
        this.setIdEstado(localidades.getIdEstado());
        this.setSiglaEstado(localidades.getSiglaEstado());
        this.setRegiaoNome(localidades.getRegiaoNome());
        this.setNomeCidade(localidades.getNomeCidade());
        this.setNomeMesorregiao(localidades.getNomeMesorregiao());
        this.setNomeFormatado(localidades.getNomeFormatado());
    }

}
