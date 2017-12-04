package com.pwi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator="my_seq")
    @SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
    @Column(name = "company_id")
    private String companyId;
    @Column(name = "company_name")
    private String companyName;
    @OneToMany(mappedBy = "companyModel",fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonIgnore
    private Collection<Brands> brands;

    public Company() {
    }

    public Company(String companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @OneToMany(targetEntity = Brands.class, mappedBy = "companyModel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Collection<Brands> getBrands() {
        return brands;
    }

    public void setBrands(Collection<Brands> brands) {
        this.brands = brands;
    }
}
