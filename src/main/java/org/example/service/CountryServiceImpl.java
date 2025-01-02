package org.example.service;

import org.example.dto.CountryDTO;
import org.example.entity.Country;
import org.example.mapper.CountryMapper;
import org.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CRUDInterface<CountryDTO> {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<CountryDTO> getAll() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.toCountryDTOList(countries);
    }

    @Override
    public CountryDTO getById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        return countryMapper.toCountryDTO(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public CountryDTO create(CountryDTO dto) {
        Country country = countryMapper.toCountryEntity(dto);
        Country savedCountry = countryRepository.save(country);
        return countryMapper.toCountryDTO(savedCountry);
    }

    @Override
    public CountryDTO updateById(CountryDTO dto, Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        country.setIsoCode(dto.getIsoCode());
        Country updatedCountry = countryRepository.save(country);
        return countryMapper.toCountryDTO(updatedCountry);
    }
    @Override
    public String getName(String isoCode) {
        Country country = countryRepository.findByIsoCode(isoCode)
                .orElseThrow(() -> new RuntimeException("Country not found with ISO code: " + isoCode));
        return country.getName();
    }
}
