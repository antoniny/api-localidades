package br.com.antoniny.localidades.integration.municipio.v1.dto;

public class MunicipioDto extends Municipio {

    private MicrorRegiaoDto microrregiao;

    public MunicipioDto() {
    }

    public MicrorRegiaoDto getMicrorregiao() {
        return microrregiao;
    }

    public void setMicrorregiao(MicrorRegiaoDto microrregiao) {
        this.microrregiao = microrregiao;
    }
}
