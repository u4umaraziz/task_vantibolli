package com.pwi.service;

import com.pwi.dao.GenericDao;
import com.pwi.model.Brands;
import com.pwi.model.Company;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    GenericDao genericDao;

    @Override
    public String saveBrands(Brands brands) {
        if (brands != null) {
            try {
                Brands brands1 = (Brands) genericDao.save(setCompanyIdToBrand(brands));
                return brands1.getBrandId();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public List<Brands> findBrandsByCompany(String companyId) {
        List<Brands> brands = genericDao.findById("FROM Brands where company_id=:companyId", "companyId", companyId);
        return brands;
    }

    @Override
    public void updateBrand(Brands brands) {
        try {
            genericDao.update(setCompanyIdToBrand(brands));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteBrand(String brandId) {
        if (StringUtils.isNotBlank(brandId)) {
            Brands brands = genericDao.findById(Brands.class, brandId);
            genericDao.delete(brands);
        }
    }


    public Brands setCompanyIdToBrand(Brands brands) {
        Company company = new Company();
        if (brands != null && StringUtils.isNotBlank(brands.getCompanyId())) {
            company.setCompanyId(brands.getCompanyId());
            brands.setCompanyModel(company);
        }
        return brands;
    }
}
