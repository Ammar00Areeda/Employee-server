package com.sitech.employee.domain.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryResponse {

    private double grossSalary;
    private double netSalary;
    private double tax;
}
