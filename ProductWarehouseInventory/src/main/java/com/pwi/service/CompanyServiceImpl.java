package com.pwi.service;

import com.pwi.dao.GenericDao;
import com.pwi.model.Company;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private GenericDao genericDao;

    @Override
    public Company saveCompany(Company c) {
        if (c != null) {
            return (Company) genericDao.save(c);
        }
        return null;
    }

    @Override
    public List<Company> findAll() {
        return genericDao.findAll("Company");
    }

    @Override
    public void updateCompany(Company company) {
        if (company != null) {
            genericDao.update(company);
        }
    }

    @Override
    public void deleteCompany(String companyId) {
        if (StringUtils.isNotBlank(companyId)) {
            Company company = genericDao.findById(Company.class, companyId);
            genericDao.delete(company);
        }
    }
}
