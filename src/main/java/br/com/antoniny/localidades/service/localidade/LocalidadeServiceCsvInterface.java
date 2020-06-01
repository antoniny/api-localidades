package br.com.antoniny.localidades.service.localidade;

import br.com.antoniny.localidades.service.dto.LocalidadeResponseCsvDto;

public interface LocalidadeServiceCsvInterface {

    String getAllLocalidadesCSV();

    String getNameFieldsDto(LocalidadeResponseCsvDto localidadeCsv);
}
