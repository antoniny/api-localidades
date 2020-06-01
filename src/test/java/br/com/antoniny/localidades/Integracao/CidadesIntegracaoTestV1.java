package br.com.antoniny.localidades.Integracao;

import br.com.antoniny.localidades.LocalidadesApplicationTests;
import br.com.antoniny.localidades.controller.v1.LocalidadeController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableAutoConfiguration
public class CidadesIntegracaoTestV1 extends LocalidadesApplicationTests {

    private MockMvc mockMvc;

    @Value("${api.v1.path}${api.v1.localidades.idCidade.path}")
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
    public void integracao_BuscaIdCidadePorNomeCidade_200Request() throws Exception {

        String apiParamValue = "Palhoça";
        String apiParamName  = "nomeCidade";

                this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName,apiParamValue))
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
                )
                .andExpect(jsonPath("$[0].idCidade",is(4211900)))
                .andDo(MockMvcResultHandlers.print())
                ;

    }

    @Test
    public void integracao_BuscaIdCidadePorNomeCidade_toUpperLowerCaseCache() throws Exception {

        String apiParamValue = "PALHOÇA";
        String apiParamName  = "nomeCidade";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName,apiParamValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
                )
                .andExpect(jsonPath("$[0].idCidade",is(4211900)))
                .andDo(MockMvcResultHandlers.print())
        ;

        apiParamValue = "palhoça";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName,apiParamValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
                )
                .andExpect(jsonPath("$[0].idCidade",is(4211900)))
                .andDo(MockMvcResultHandlers.print())
        ;

    }

    @Test
    public void integracao_BuscaIdCidade_Cache() throws Exception {

        String apiParamValue = "BeLo HoRizOntE";
        String apiParamName  = "nomeCidade";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName,apiParamValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
                )
                .andExpect(jsonPath("$[0].idCidade",is(3106200)))
                .andDo(MockMvcResultHandlers.print())
        ;

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName,apiParamValue))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8")
                )
                .andExpect(jsonPath("$[0].idCidade",is(3106200)))
                .andDo(MockMvcResultHandlers.print())
        ;

    }


    @Test
    public void integracao_BuscaIdCidade_404NotFound() throws Exception {

        String apiParamValue = "Floripa";
        String apiParamName = "nomeCidade";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
                        .param(apiParamName, apiParamValue))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andDo(MockMvcResultHandlers.print())

        ;
    }


    @Test
    public void integracao_BuscaIdCidade_NullParameter_400BadRequest() throws Exception {

        String apiParamValue = null;
        String apiParamName = "nomeCidade";

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get(apiUrl)
       //                 .param(apiParamName, apiParamValue)
                        )
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print())

        ;
    }

}
