package br.com.antoniny.localidades.service.dto;

public class LocalidadeResponseJsonDto extends LocalidadeDto {

    public LocalidadeResponseJsonDto() {
        super();
    }

    public LocalidadeResponseJsonDto(LocalidadeResponseDto localidadeDto) {
        super();
        this.setIdEstado(localidadeDto.getIdEstado());
        this.setSiglaEstado(localidadeDto.getSiglaEstado());
        this.setRegiaoNome(localidadeDto.getRegiaoNome());
        this.setNomeCidade(localidadeDto.getNomeCidade());
        this.setNomeMesorregiao(localidadeDto.getNomeMesorregiao());
        this.setNomeFormatado(localidadeDto.getNomeFormatado());
    }

}
