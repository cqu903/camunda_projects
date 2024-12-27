package com.zerofinance.workflow.externaltask.spin;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerMsg {
    private String name;
    private String product;
    private int productAge;
    private Date purchaseDate;
    private ProductType productType;
    private List<String> repairSites;
}
