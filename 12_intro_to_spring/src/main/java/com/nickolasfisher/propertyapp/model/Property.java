package com.nickolasfisher.propertyapp.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Property {
    private int id;
    private String addressLine1;
    private String addressLine2;
    private int zipCode;
    private int sqFootage;
    private int lotSize;
    private long askingPrice;
}
