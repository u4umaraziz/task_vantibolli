package com.pwi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_mapping")
public class ProductMapping {

    @Id
    @Column(name="product_mapping_id")
    private String productMappingId;
    @Column(name="warehouse_id")
    private String wareHouseId;
    @Column(name="brand_id")
    private String brandId;

    public String getProductMappingId() {
        return productMappingId;
    }

    public void setProductMappingId(String productMappingId) {
        this.productMappingId = productMappingId;
    }

    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
