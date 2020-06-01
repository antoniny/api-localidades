package br.com.antoniny.localidades.web;

import br.com.antoniny.localidades.controller.v1.LocalidadeController;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceCsv;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceJson;
import br.com.antoniny.localidades.service.municipio.MunicipioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LocalidadeController.class)
@TestPropertySource(locations = "classpath:teste.properties")
public class CidadesTestV1 {

    @Value("${api.v1.path}${api.v1.localidades.idCidade.path}")
    private String apiPath;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    LocalidadeServiceCsv localidadeCsvService;

    @MockBean
    LocalidadeServiceJson localidadeJsonService;

    @MockBean
    MunicipioService municipioService;

    @Test
    void entradaValidaRetorna200_CidadesId() throws Exception {
        String nomeCidade = "Florianópolis";

        mockMvc.perform(get(apiPath)
                .contentType("application/json")
                .param("nomeCidade", nomeCidade))
                .andExpect(status().isOk());
    }


    @Test
    void entradaValida_Parameter_ControllerLowerCase_ServiceUpperCase() throws Exception {

        String nomeCidade = "São josé";

        mockMvc.perform(get(apiPath)
                .contentType("application/json")
                .param("nomeCidade", nomeCidade))
                .andExpect(status().isOk());

        ArgumentCaptor<String> cidadeCaptor = ArgumentCaptor.forClass(String.class);
        verify(municipioService, times(1)).findIdMunicipioByName(cidadeCaptor.capture());
        assertThat(cidadeCaptor.getValue()).isEqualTo(nomeCidade.toUpperCase());

    }


    @Test
    void entradaValidaRetorna400_ParametroNomeIsNotPresent_CidadesId() throws Exception {
        String nomeCidade = "Palhoça";

        mockMvc.perform(get(apiPath)
                .contentType("application/json")
                .param("parameter", nomeCidade))
                .andExpect(status().isBadRequest());
    }


    }
