package br.com.antoniny.localidades.service.municipio.v2;

import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;
import br.com.antoniny.localidades.integration.municipio.v2.MunicipioV2Integration;
import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import br.com.antoniny.localidades.service.estado.v1.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("municipioV2")
public class MunicipioV2Service implements MunicipioV2ServiceInterface {

    @Autowired
    private MunicipioV2Integration municipioV2Integration;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioV2ServiceCacheable municipioV2ServiceCacheable;

    @Override
    public List<MunicipioDto> getMunicipiosUf(String uf) {
        return municipioV2Integration.getMunicipios(uf);
    }

    @Override
    public List<MunicipioDto> getAllMunicipios() {

        List<MunicipioDto> municipioDtoList = new ArrayList<>();

        estadoService
                .getAllEstados()
                .forEach(estado -> municipioDtoList.addAll(getMunicipiosUf(estado.getSigla())));

        return municipioDtoList;
    }


    @Override
    public ResponseEntity<List<MunicipioIdResponseDto>> findIdMunicipioByName (String nomeMunicipio) {
        return municipioV2ServiceCacheable.findByName(nomeMunicipio);
    }
}
