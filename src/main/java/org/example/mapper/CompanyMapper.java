package org.example.mapper;

import org.example.dto.CompanyDTO;
import org.example.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = CountryMapper.class)
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "country.isoCode", target = "country.isoCode")
    @Mapping(source = "id", target = "id")
    CompanyDTO toCompanyDTO(Company company);

    @Mapping(source = "country.isoCode", target = "country.isoCode")
    @Mapping(source = "id", target = "id")

    Company toCompanyEntity(CompanyDTO dto);

    List<CompanyDTO> toCompanyDTOList(List<Company> companies);
}
