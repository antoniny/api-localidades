package br.com.antoniny.localidades.controller.v1;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseJsonDto;
import br.com.antoniny.localidades.service.dto.MunicipioIdResponseDto;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceCsv;
import br.com.antoniny.localidades.service.localidade.LocalidadeServiceJson;
import br.com.antoniny.localidades.service.municipio.MunicipioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Localidade", tags = {"Localidades"},description = "Obtem informações de localidades")
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


    @ApiOperation(value = "Obtém os municípios cadastros no IBGE no formato JSON.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna com sucesso a lista de municípios."),
            @ApiResponse(code = 400, message = "Ocorreu um problema com sua requisição."),
            @ApiResponse(code = 404, message = "Não foram encontrado dados."),
            @ApiResponse(code = 406, message = "Ocorreu um problema com sua requisição"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "localidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LocalidadeResponseJsonDto>> getAllLocalidadesJson(HttpServletResponse response){
        response.setContentType("application/json;charset="+charset);
        response.setHeader("Content-Disposition", "attachment; filename="+fileAttachmentJson);

        return localidadeJsonService.getAllLocalidadesJson();
    }


    @ApiOperation(value = "Obtém os municípios cadastros no IBGE no formato CSV.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna com sucesso a lista de municípios."),
            @ApiResponse(code = 400, message = "Ocorreu um problema com sua requisição."),
            @ApiResponse(code = 404, message = "Não foram encontrado dados."),
            @ApiResponse(code = 406, message = "Ocorreu um problema com sua requisição"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
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

    @ApiOperation(value = "Obtém o(s) código(s) ibge(id) do(s) município(s) através do nome do município.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna com sucesso a lista com o(s) id(s) do(s) município(s)."),
            @ApiResponse(code = 400, message = "Ocorreu um problema com sua requisição."),
            @ApiResponse(code = 404, message = "Não foram encontrado dados."),
            @ApiResponse(code = 406, message = "Ocorreu um problema com sua requisição"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "localidades/cidades/id" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MunicipioIdResponseDto>> getIdCidade(@RequestParam String nomeCidade){

        return municipioService.findIdMunicipioByName(nomeCidade.toUpperCase());
    }
}
