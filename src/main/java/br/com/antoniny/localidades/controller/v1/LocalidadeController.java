package br.com.antoniny.localidades.controller.v1;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseJsonDto;
import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceCsv;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceJson;
import br.com.antoniny.localidades.service.municipio.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class LocalidadeController  {

    @Autowired
    LocalidadeServiceJson localidadeJsonService;

    @Autowired
    LocalidadeServiceCsv localidadeCsvService;

    @Autowired
    MunicipioService municipioService;

    @Value("${api.v1.localidades.csv.attachment}")
    private String fileAttachmentCSV;

    @Value("${api.v1.localidades.json.attachment}")
    private String fileAttachmentJson;

    @Value("${api.v1.localidades.charset}")
    private String charset;


    @GetMapping(value = "localidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJson(HttpServletResponse response){
        response.setContentType("application/json;charset="+charset);
        response.setHeader("Content-Disposition", "attachment; filename="+fileAttachmentJson);

        return localidadeJsonService.getAllLocalidadesJson();
    }


    @GetMapping(value = "localidades/csv", produces = "application/vnd.ms-excel")
    public ResponseEntity<StreamingResponseBody> getAllLocalidadesCSV(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel;charset="+charset);
        response.setHeader("Content-Disposition", "attachment; filename="+fileAttachmentCSV);

        String csv = localidadeCsvService.getAllLocalidadesCSV();

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(0xEF);   // 1st byte of BOM
        outputStream.write(0xBB);
        outputStream.write(0xBF);   // last byte of BOM

        StreamingResponseBody responseBody = new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream out) throws IOException {
                OutputStreamWriter writer = new OutputStreamWriter(out, charset);
                writer.write(csv);
                writer.flush();
            }
        };

        return  new ResponseEntity(responseBody, HttpStatus.OK);
    }


    @GetMapping(value = "localidades/cidades/id" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MunicipioIdResponseDto>> getIdCidade(@RequestParam String nomeCidade){

        return municipioService.findIdMunicipioByName(nomeCidade.toUpperCase());
    }
}
