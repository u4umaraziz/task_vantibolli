package com.pwi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @Column(name="product_size_id")
    private String productSizeId;
    @Column(name="product_size_value")
    private String productSizeVal;
    @Column(name="product_id")
    private String productId;

    public String getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(String productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getProductSizeVal() {
        return productSizeVal;
    }

    public void setProductSizeVal(String productSizeVal) {
        this.productSizeVal = productSizeVal;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
