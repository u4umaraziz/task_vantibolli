package com.pwi.service;

import com.pwi.model.Brands;

import java.util.List;

public interface BrandService {
    public String saveBrands(Brands brands);
    List<Brands> findBrandsByCompany(String companyId);
    public void updateBrand(Brands brands);
    public void deleteBrand(String brandId);
}

