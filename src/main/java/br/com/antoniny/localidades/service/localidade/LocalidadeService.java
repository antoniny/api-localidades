package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseDto;
import br.com.antoniny.localidades.service.estado.v1.EstadoService;
import br.com.antoniny.localidades.service.municipio.v1.MunicipioService;
import br.com.antoniny.localidades.service.municipio.v2.MunicipioV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("localidade")
public class LocalidadeService implements LocalidadeServiceInterface {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private MunicipioService municipioService;

    @Override
    public List<LocalidadeResponseDto> getAllLocalidades() {
        List<LocalidadeResponseDto> localidades = new ArrayList<>();

        estadoService
                .getAllEstados()
                .forEach(estado -> localidades.addAll(
                        municipioService
                                .getMunicipiosUf(estado.getSigla())
                                .stream()
                                .map(municipio -> new LocalidadeResponseDto(estado,municipio))
                                .collect(Collectors.toList())
                )
                );

        return localidades;
    }

}
