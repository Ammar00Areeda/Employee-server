package com.sitech.employee.controller;


import com.sitech.employee.domain.req.EmployeeReq;
import com.sitech.employee.domain.req.SalaryRequest;
import com.sitech.employee.domain.res.BaseResponse;
import com.sitech.employee.domain.res.EmployeeRes;
import com.sitech.employee.domain.res.SalaryResponse;
import com.sitech.employee.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // TODO: 9/4/2022 get salary by id ()
    @GetMapping(("/{id}"))
    public BaseResponse<SalaryResponse> getSalaryById(@PathVariable long id){
        salaryService.getSalaryById(id);
        return new BaseResponse<>(200,"this is the salary");
    }
    // TODO: 9/4/2022 post salary by id ()




    @PostMapping("/{id}")
    public BaseResponse setSalaryById(@RequestBody SalaryRequest salaryRequest){
        return salaryService.setSalary(salaryRequest);
    }
    // TODO: 9/4/2022 update salary()


}
