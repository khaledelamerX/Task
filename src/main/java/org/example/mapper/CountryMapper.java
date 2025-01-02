package org.example.mapper;

import org.example.dto.CountryDTO;
import org.example.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "isoCode", target = "isoCode")
    CountryDTO toCountryDTO(Country country);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isoCode", target = "isoCode")
    Country toCountryEntity(CountryDTO dto);

    List<CountryDTO> toCountryDTOList(List<Country> countries);
}

