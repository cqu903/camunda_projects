package com.zerofinance.workflow.externaltask.spin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductType {
    private String brand;
    private String model;
    private int power;
}
