package br.com.antoniny.localidades.service.municipio.v1;


import br.com.antoniny.localidades.integration.municipio.v1.dto.MunicipioDto;
import br.com.antoniny.localidades.integration.municipio.v1.integration.MunicipioIntegration;
import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import br.com.antoniny.localidades.service.estado.v1.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("municipio")
//@CacheConfig(cacheNames = "findIdMunicipioByName")
public class MunicipioService implements MunicipioServiceInterface {

    @Autowired
    private MunicipioIntegration municipioIntegration;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioServiceCacheable municipioServiceCacheable;

    @Override
    public List<MunicipioDto> getMunicipiosUf(String uf) {
        return municipioIntegration.getMunicipios(uf);
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
        return municipioServiceCacheable.findByName(nomeMunicipio);
    }


}
