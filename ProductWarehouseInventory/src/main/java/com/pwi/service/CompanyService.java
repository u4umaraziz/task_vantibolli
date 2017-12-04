package com.pwi.service;

import com.pwi.model.Company;

import java.util.List;

public interface CompanyService {
    public Company saveCompany(Company company);
    public List<Company> findAll();
    public void updateCompany(Company company);
    public void deleteCompany(String companyId);
}
