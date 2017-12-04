package com.pwi.web;

import com.pwi.model.Brands;
import com.pwi.model.Company;
import com.pwi.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandRestController {

    @Autowired
    private BrandService brandService;

    /*localhost:8080/savebrand
     request params =>
     {
      "brandName"  : "{name}",
      "companyId" : "{companyId}"
     }
    */
    @RequestMapping(method = RequestMethod.POST, path = "/savebrand")
    public void saveBrand(@RequestBody Brands brands) {
        brandService.saveBrands(brands);
    }

    //localhost:8080/brandbycompanyid/6
    @RequestMapping(method = RequestMethod.GET, path = "/brandbycompanyid/{companyid}")
    public List<Brands> findAllBrandsByCompany(@PathVariable(value = "companyid") String companyId) {
        List<Brands> brandList = brandService.findBrandsByCompany(companyId);
        return brandList;
    }

    // localhost:8080/edit-brand  request for update
    /*Params
    {
        "brandId" : "{brandId}",
        "name" : "{Brand Name}",
        "companyId": "{companyId}"
    }*/
    @RequestMapping(method = RequestMethod.PUT, path = "/edit-brand")
    public void updateBrand(@RequestBody Brands brands) {
        brandService.updateBrand(brands);
    }

    // localhost:8080/delete-brand/2 request for delete
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete-brand/{id}")
    public void deleteBrand(@PathVariable(value = "id") String brandId) {
        brandService.deleteBrand(brandId);
    }

    public BrandRestController(BrandService brandService){
        this.brandService = brandService;
    }
}
