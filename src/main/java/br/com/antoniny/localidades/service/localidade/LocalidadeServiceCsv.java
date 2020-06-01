package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.config.csv.ConvertResponseDtoToCsv;
import br.com.antoniny.localidades.service.dto.LocalidadeResponseCsvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("localidade_csv")
public class LocalidadeServiceCsv implements LocalidadeServiceCsvInterface {

    @Autowired
    LocalidadeService localidadeService;

    @Autowired
    ConvertResponseDtoToCsv convertResponseDtoToCsv;

    @Value("${config.csv.field.separator}")
    private String fieldSeparator;

    @Value("${config.csv.line.separator}")
    private String lineSeparator;

    @Override
    public String getAllLocalidadesCSV() {

        List<LocalidadeResponseCsvDto> localidades = new ArrayList<>();
        localidades.addAll(localidadeService.getAllLocalidades().stream().map(LocalidadeResponseCsvDto::new).collect(Collectors.toList()));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getNameFieldsDto(new LocalidadeResponseCsvDto()));

        localidades.forEach(dto -> stringBuffer.append(convertResponseDtoToCsv.toCsv(dto)));

        return  stringBuffer.toString();
    }

    @Override
    public String getNameFieldsDto (LocalidadeResponseCsvDto localidadeCsv) {

        String localidadeCsvFields = Arrays.stream(localidadeCsv.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining(fieldSeparator));
        String localidadeFields    = Arrays.stream(localidadeCsv.getClass().getSuperclass().getDeclaredFields()).map(Field::getName).collect(Collectors.joining(fieldSeparator));

        return localidadeFields +
                ( (localidadeCsvFields.isEmpty() )
                        ? lineSeparator
                        : localidadeCsvFields + lineSeparator
                );

    }
}
