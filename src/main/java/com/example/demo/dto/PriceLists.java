package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceLists implements Serializable
{
    private String packageID;
    private String creationtime;
    private List<PriceList> priceLists;
}