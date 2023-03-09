package com.eleiatech.stockmanagement.productservice.request;

import lombok.Data;

@Data
public class ProductUpdatedRequest {//updaterequestler ıd yazılır.

    private long productId;
    private String productName;
    private int quantity;

    private double price;
}
