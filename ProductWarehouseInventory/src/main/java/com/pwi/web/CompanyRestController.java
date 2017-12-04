package com.pwi.web;

import com.pwi.model.Company;
import com.pwi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public void saveCompany(@RequestBody Company companyName) {
        companyService.saveCompany(companyName);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public List<Company> findAllCompany() {
        List<Company> companyList = companyService.findAll();
        return companyList;
    }

    // localhost:8080/edit-company  request for update
    @RequestMapping(method = RequestMethod.PUT, path = "/edit-company")
    public void updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
    }

    // localhost:8080/delete-company/2 request for delete
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete-company/{id}")
    public void deleteCompany(@PathVariable(value = "id") String companyId) {
        companyService.deleteCompany(companyId);
    }

}