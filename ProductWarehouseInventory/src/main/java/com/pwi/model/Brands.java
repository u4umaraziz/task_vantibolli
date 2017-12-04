package com.pwi.model;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brands {

    @Id
    @GeneratedValue(generator="my_seq")
    @SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
    @Column(name="brand_id")
    private String brandId;
    @Column(name="name")
    private String name;
    @Transient
    private String companyId;
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    private Company companyModel;

    public Brands() {

    }

    public Brands(String brandId, String companyId, String brandName) {
        this.name = brandName;
        this.companyId = companyId;
        this.brandId = brandId;

    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompanyModel() {
        return companyModel;
    }

    public void setCompanyModel(Company companyModel) {
        this.companyModel = companyModel;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
