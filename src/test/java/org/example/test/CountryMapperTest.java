package org.example.test;

import org.example.dto.CountryDTO;
import org.example.entity.Country;
import org.example.mapper.CountryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CountryMapperTest {

    @Autowired
    private CountryMapper countryMapper;

    @Test
    void testToCountryDTO() {
        // Arrange
        Country country = new Country();
        country.setId(1L);
        country.setIsoCode("US");

        // Act
        CountryDTO dto = countryMapper.toCountryDTO(country);

        // Assert
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("US", dto.getIsoCode());
    }

    @Test
    void testToCountryEntity() {
        // Arrange
        CountryDTO dto = new CountryDTO();
        dto.setId(1L);
        dto.setIsoCode("US");

        // Act
        Country country = countryMapper.toCountryEntity(dto);

        // Assert
        assertNotNull(country);
        assertEquals(1L, country.getId());
        assertEquals("US", country.getIsoCode());
    }

    @Test
    void testToCountryDTOList() {
        // Arrange
        Country country1 = new Country();
        country1.setId(1L);
        country1.setIsoCode("US");

        Country country2 = new Country();
        country2.setId(2L);
        country2.setIsoCode("CA");

        List<Country> countries = List.of(country1, country2);

        // Act
        List<CountryDTO> dtos = countryMapper.toCountryDTOList(countries);

        // Assert
        assertNotNull(dtos);
        assertEquals(2, dtos.size());
        assertEquals("US", dtos.get(0).getIsoCode());
        assertEquals("CA", dtos.get(1).getIsoCode());
    }
}
