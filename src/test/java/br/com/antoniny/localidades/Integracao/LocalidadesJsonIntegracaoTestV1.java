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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LocalidadesJsonIntegracaoTestV1 extends LocalidadesApplicationTests {

    private MockMvc mockMvc;

    @Value("${api.v1.path}${api.v1.localidades.json.path}")
    private String apiUrl;

    @Value("${config.language.code.default}")
    private String languageCode;

    @Autowired
    private LocalidadeController localidadeController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(localidadeController).build();
    }

    @Test
    public void integracao_BuscaLocalidadesJSON_200Request() throws Exception {

        String siglaEstado = "RO";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.header().exists("Content-Disposition"))
                .andExpect(MockMvcResultMatchers.header().stringValues("attachment; filename=localidades.json"))
                .andExpect(jsonPath("$[0].siglaEstado",is(siglaEstado)))
                .andDo(MockMvcResultHandlers.print())
        ;

    }

}
