package br.com.antoniny.localidades.Integracao;

import br.com.antoniny.localidades.LocalidadesApplicationTests;
import br.com.antoniny.localidades.controller.v1.LocalidadeController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LocalidadesCsvIntegracaoTestV1 extends LocalidadesApplicationTests {

    private MockMvc mockMvc;

    @Value("${api.v1.path}${api.v1.localidades.csv.path}")
    private String apiPath;

    @Value("${config.language.code.default}")
    private String languageCode;

    @Autowired
    private LocalidadeController localidadeController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(localidadeController).build();
    }

    @Test
    public void integracao_BuscaLocalidadesCSV_200Request() throws Exception {

        String resultString = "11;RO;Norte;Cabixi;Leste Rondoniense;Cabixi/RO";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiPath)
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/vnd.ms-excel;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.header().exists("Content-Disposition"))
                .andExpect(MockMvcResultMatchers.header().stringValues("attachment; filename=localidades.csv"))
                .andExpect(MockMvcResultMatchers.content().string(containsString(resultString)))
                .andDo(MockMvcResultHandlers.print())
        ;

    }


}
