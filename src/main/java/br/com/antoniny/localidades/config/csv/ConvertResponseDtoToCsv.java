package br.com.antoniny.localidades.config.csv;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseCsvDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("csvFile")
public class ConvertResponseDtoToCsv {

    @Value("${config.csv.field.separator}")
    private String field_separator;

    @Value("${config.csv.line.separator}")
    private String line_separator;

    public String toCsv(LocalidadeResponseCsvDto localidadeCsv) {

        StringBuffer line = new StringBuffer();

        line.append(localidadeCsv.getIdEstado());
        line.append(field_separator);
        line.append(localidadeCsv.getSiglaEstado());
        line.append(field_separator);
        line.append(localidadeCsv.getRegiaoNome());
        line.append(field_separator);
        line.append(localidadeCsv.getNomeCidade());
        line.append(field_separator);
        line.append(localidadeCsv.getNomeMesorregiao());
        line.append(field_separator);
        line.append(localidadeCsv.getNomeFormatado());
        line.append(line_separator);


        return line.toString();
    }

}

