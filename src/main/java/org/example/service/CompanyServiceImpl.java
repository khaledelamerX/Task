package org.example.service;

import org.example.dto.CompanyDTO;
import org.example.entity.Company;
import org.example.mapper.CompanyMapper;
import org.example.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
        @Autowired
        CompanyRepository companyRepository;

        @Autowired
        CompanyMapper companyMapper;

        @Override
        public List<CompanyDTO> getAll() {
            List<Company> companies = companyRepository.findAll();
            return companyMapper.toCompanyDTOList(companies);
        }

        @Override
        public CompanyDTO getById(Long id) {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
            return companyMapper.toCompanyDTO(company);
        }

        @Override
        public void deleteById(Long id) {
            companyRepository.deleteById(id);
        }

        @Override
        public CompanyDTO create(CompanyDTO dto) {
            Company company = companyMapper.toCompanyEntity(dto);
            Company savedCompany = companyRepository.save(company);
            return companyMapper.toCompanyDTO(savedCompany);
        }

        @Override
        public CompanyDTO updateById(CompanyDTO dto, Long id) {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
            company.setName(dto.getName());
            company.setCountry(dto.getCountry());
            Company updatedCompany = companyRepository.save(company);
            return companyMapper.toCompanyDTO(updatedCompany);
        }
}
