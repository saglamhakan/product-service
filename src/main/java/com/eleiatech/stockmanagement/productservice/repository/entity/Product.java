package com.eleiatech.stockmanagement.productservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "stock_management")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Builder.Default // Bu alanı constructorda her zaman parametre olarak geçecek
    @Column(name = "product_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date productUpdatedDate=new Date();

    @Builder.Default // Bu alanı constructorda her zaman parametre olarak geçecek
    @Column(name = "product_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyy-MM-dd")
    private Date productCreatedDate=new Date();

    @Column(name = "is_deleted")
    private boolean deleted;
}
