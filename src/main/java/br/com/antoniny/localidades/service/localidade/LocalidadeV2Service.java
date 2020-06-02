package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseDto;
import br.com.antoniny.localidades.service.estado.v1.EstadoService;
import br.com.antoniny.localidades.service.estado.v2.EstadoV2Service;
import br.com.antoniny.localidades.service.municipio.v2.MunicipioV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("localidadeV2")
public class LocalidadeV2Service implements LocalidadeServiceInterface {

    @Autowired
    private EstadoV2Service estadoV2Service;

    @Autowired
    private MunicipioV2Service municipioV2Service;

    @Override
    public List<LocalidadeResponseDto> getAllLocalidades() {
        List<LocalidadeResponseDto> localidades = new ArrayList<>();

        estadoV2Service
                .getAllEstados()
                .forEach(estado -> localidades.addAll(
                        municipioV2Service
                                .getMunicipiosUf(estado.getSigla())
                                .stream()
                                .map(municipio -> new LocalidadeResponseDto(estado,municipio))
                                .collect(Collectors.toList())
                )
                );

        return localidades;
    }

}
