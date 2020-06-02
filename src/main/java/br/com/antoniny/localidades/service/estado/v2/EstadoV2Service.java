package br.com.antoniny.localidades.service.estado.v2;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;
import br.com.antoniny.localidades.integration.estado.v1.integration.EstadoIntegration;
import br.com.antoniny.localidades.integration.estado.v2.integration.EstadoV2Integration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("estadosV2")
public class EstadoV2Service implements EstadoV2ServiceInterface {

    @Autowired
    private EstadoV2Integration estadoV2Integration;

    @Override
    public List<EstadoDto> getAllEstados() {
        return estadoV2Integration.getEstados();
    }


}
