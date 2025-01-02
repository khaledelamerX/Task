package org.example.service;

import org.example.dto.CountryDTO;

public interface CountryService extends CRUDInterface<CountryDTO> {
    String getName(String isoCode);

}
