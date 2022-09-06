package com.sitech.employee.service;

import com.sitech.employee.domain.entitiy.EmployeeEntity;
import com.sitech.employee.domain.entitiy.SalaryEntity;
import com.sitech.employee.domain.req.SalaryRequest;
import com.sitech.employee.domain.res.BaseResponse;
import com.sitech.employee.domain.res.SalaryResponse;
import com.sitech.employee.repository.SalaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public BaseResponse<SalaryResponse> getSalaryById(long id) {
        Optional<SalaryEntity> optionalEmployeeEntity = salaryRepository.findById(id);
        return new BaseResponse<>();
    }

    public BaseResponse setSalary (SalaryRequest salaryRequest) {

        SalaryEntity salaryEntity = new SalaryEntity();
        salaryEntity.setSalary(salaryRequest.getSalary());
        return new BaseResponse<>();
    }

    public BaseResponse updateById(long id , SalaryRequest salaryRequest) {
        SalaryResponse salaryResponse= new SalaryResponse();
        salaryResponse.setNetSalary(salaryRequest.getSalary());

        return new BaseResponse<>();
    }
}
