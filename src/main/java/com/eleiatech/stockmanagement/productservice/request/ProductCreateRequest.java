package com.eleiatech.stockmanagement.productservice.request;

import lombok.Data;

@Data
public class ProductCreateRequest {//CreateRequestlere ıd yazmaya gerek yok çünkü entity de yazdık.
    private String productName;
    private int quantity;

    private double price;
}
