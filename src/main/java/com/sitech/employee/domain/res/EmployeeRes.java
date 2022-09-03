package com.sitech.employee.domain.res;

import com.sitech.employee.repository.SalaryRepository;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeRes {

    private long id;
    private String employeeName;
    private String joinedDate;
    private String jobTitle;

    private List<SalaryResponse> salaryResponseList;

}
