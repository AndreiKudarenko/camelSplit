package com.example.demo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceList implements Serializable {

    private String action;
    private String newPackage;
    private String priceListId;
    private String productId;
    private String listPrice;
    private String listCost;
    private String discount1;
    private String discount2;
    private String discount3;
    private String discount4;
    private String discount5;
    private String discount6;
    private String discount7;
    private String discount8;
    private String discount9;
    private String discount10;
    private String discount11;
    private String discCurr;
    private String startDate;

}