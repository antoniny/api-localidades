package br.com.antoniny.localidades.web;

import br.com.antoniny.localidades.controller.v1.LocalidadeController;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceCsv;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceJson;
import br.com.antoniny.localidades.service.municipio.MunicipioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LocalidadeController.class)
@TestPropertySource(locations = "classpath:teste.properties")
public class LocalidadesCsvTestV1 {

    @Value("${api.v1.path}${api.v1.localidades.csv.path}")
    private String apiPath;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LocalidadeServiceCsv localidadeCsvService;

    @MockBean
    LocalidadeServiceJson localidadeJsonService;

    @MockBean
    MunicipioService municipioService;


    @Test
    void entradaValidaRetorna200_Localidades() throws Exception {

        mockMvc.perform(get(apiPath)
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
