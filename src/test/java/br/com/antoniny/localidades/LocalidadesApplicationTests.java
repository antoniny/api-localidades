package br.com.antoniny.localidades;

import br.com.antoniny.localidades.Integracao.CidadesIntegracaoTestV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalidadesApplication.class)
@TestPropertySource(locations = "classpath:teste.properties")
public class LocalidadesApplicationTests {

    @Test
    public void contextLoads() {
    }
}
