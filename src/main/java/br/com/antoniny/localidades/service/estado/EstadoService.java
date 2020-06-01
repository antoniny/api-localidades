package br.com.antoniny.localidades.service.estado;

import br.com.antoniny.localidades.integration.estado.v1.dto.EstadoDto;
import br.com.antoniny.localidades.integration.estado.v1.integration.EstadoIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("estados")
public class EstadoService implements EstadoServiceInterface{

    @Autowired
    EstadoIntegration estadoIntegration;


    @Override
    public List<EstadoDto> getAllEstados() {
        return estadoIntegration.getEstados();
    }
}