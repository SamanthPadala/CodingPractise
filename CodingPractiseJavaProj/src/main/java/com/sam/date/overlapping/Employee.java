package com.sam.date.overlapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String effectiveDate;
    private String expirationDate;
}
