package com.pwi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name="product_id")
    private String productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="in_stock")
    private String inStock;
    @Column(name="avl_qty")
    private String avaliableQty;
    @Column(name="in_transit")
    private String inTransit;
    @Column(name="moq")
    private String moq;
    @Column(name="qpb")
    private String qpb;
    @Column(name="reorder_point")
    private String reOrderPoint;
    @Column(name="product_type_id")
    private String productTypeId;
    @Column(name="brand_id")
    private String brandId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public String getAvaliableQty() {
        return avaliableQty;
    }

    public void setAvaliableQty(String avaliableQty) {
        this.avaliableQty = avaliableQty;
    }

    public String getInTransit() {
        return inTransit;
    }

    public void setInTransit(String inTransit) {
        this.inTransit = inTransit;
    }

    public String getMoq() {
        return moq;
    }

    public void setMoq(String moq) {
        this.moq = moq;
    }

    public String getQpb() {
        return qpb;
    }

    public void setQpb(String qpb) {
        this.qpb = qpb;
    }

    public String getReOrderPoint() {
        return reOrderPoint;
    }

    public void setReOrderPoint(String reOrderPoint) {
        this.reOrderPoint = reOrderPoint;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
}
