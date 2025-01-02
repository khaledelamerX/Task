package org.example.test;

import org.example.dto.CompanyDTO;
import org.example.entity.Company;
import org.example.entity.Country;
import org.example.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompanyMapperTest {

    private final CompanyMapper companyMapper = CompanyMapper.INSTANCE;

    @Test
    void testToCompanyDTO() {
        // Arrange
        Country country = new Country();
        country.setId(1L);
        country.setIsoCode("US");

        Company company = new Company();
        company.setId(1L);
        company.setName("Example Co.");
        company.setCountry(country);

        // Act
        CompanyDTO dto = companyMapper.toCompanyDTO(company);

        // Assert
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("Example Co.", dto.getName());
        assertNotNull(dto.getCountry());
        assertEquals("US", dto.getCountry().getIsoCode());
    }

    @Test
    void testToCompanyEntity() {
        // Arrange
        Country country = new Country();
        country.setId(1L);
        country.setIsoCode("US");

        CompanyDTO dto = new CompanyDTO();
        dto.setId(1L);
        dto.setName("Example Co.");
        dto.setCountry(country);

        // Act
        Company company = companyMapper.toCompanyEntity(dto);

        // Assert
        assertNotNull(company);
        assertEquals(1L, company.getId());
        assertEquals("Example Co.", company.getName());
        assertNotNull(company.getCountry());
        assertEquals("US", company.getCountry().getIsoCode());
    }

    @Test
    void testToCompanyDTOList() {
        // Arrange
        Country country1 = new Country();
        country1.setId(1L);
        country1.setIsoCode("US");

        Country country2 = new Country();
        country2.setId(2L);
        country2.setIsoCode("CA");

        Company company1 = new Company();
        company1.setId(1L);
        company1.setName("Company A");
        company1.setCountry(country1);

        Company company2 = new Company();
        company2.setId(2L);
        company2.setName("Company B");
        company2.setCountry(country2);

        List<Company> companies = List.of(company1, company2);

        // Act
        List<CompanyDTO> dtos = companyMapper.toCompanyDTOList(companies);

        // Assert
        assertNotNull(dtos);
        assertEquals(2, dtos.size());
        assertEquals("Company A", dtos.get(0).getName());
        assertEquals("US", dtos.get(0).getCountry().getIsoCode());
        assertEquals("Company B", dtos.get(1).getName());
        assertEquals("CA", dtos.get(1).getCountry().getIsoCode());
    }}