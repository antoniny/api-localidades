package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseJsonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service("localidade_json")
public class LocalidadeServiceJson implements LocalidadeServiceJsonInterface {

    @Autowired
    private LocalidadeService localidadeService;

    @Autowired
    private LocalidadeV2Service localidadeV2Service;

    @Override
    public ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJson() {

        List<LocalidadeResponseJsonDto> localidades = new ArrayList<>();
        localidades.addAll(localidadeService.getAllLocalidades().stream().map(LocalidadeResponseJsonDto::new).collect(Collectors.toList()));

        return (localidades == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(new LocalidadeResponseJsonDto()))
                : ResponseEntity.ok().body(localidades) ;
    }

    @Override
    public ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJsonV2() {

        List<LocalidadeResponseJsonDto> localidades = new ArrayList<>();
        localidades.addAll(localidadeV2Service.getAllLocalidades().stream().map(LocalidadeResponseJsonDto::new).collect(Collectors.toList()));

        return (localidades == null)
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(new LocalidadeResponseJsonDto()))
                : ResponseEntity.ok().body(localidades) ;
    }
}
