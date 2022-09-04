package com.sitech.employee.controller;

import com.sitech.employee.domain.entitiy.EmployeeEntity;
import com.sitech.employee.domain.req.EmployeeReq;
import com.sitech.employee.domain.res.BaseResponse;
import com.sitech.employee.domain.res.EmployeeRes;
import com.sitech.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    @GetMapping("/")
    public List<EmployeeEntity> getAllEmployee(){
        return  employeeService.getAllEmployee();
    }


    @GetMapping("/{id}")
    public BaseResponse<EmployeeRes> getEmployee(@PathVariable long id){
      return   employeeService.getEmployee(id);

    }

    @PostMapping("/")
    public BaseResponse newEmployee(@RequestBody EmployeeReq employeeReq , EmployeeRes employeeRes ){
        return employeeService.addEmployee(employeeReq);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable long id, @RequestParam String name){
        employeeService.updateEmployee(id , name);

    }
}
