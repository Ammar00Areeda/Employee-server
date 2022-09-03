package com.sitech.employee.service;

import com.sitech.employee.domain.entitiy.EmployeeEntity;
import com.sitech.employee.domain.entitiy.SalaryEntity;
import com.sitech.employee.domain.req.EmployeeReq;
import com.sitech.employee.domain.res.BaseResponse;
import com.sitech.employee.domain.res.EmployeeRes;
import com.sitech.employee.domain.res.SalaryResponse;
import com.sitech.employee.repository.EmpolyeeRepository;
import com.sitech.employee.repository.SalaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmpolyeeRepository empolyeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;

    public BaseResponse addEmployee(EmployeeReq employeeReq) {
        log.info("Add new Employee");
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeName(employeeReq.getEmployeeName());
        employee.setJobTitle(employeeReq.getJobTitle());
        employee.setJoinedDate(employeeReq.getJoinedDate());
        empolyeeRepository.save(employee);
        return new BaseResponse(200, "Employee created");
    }

    public BaseResponse<EmployeeRes> getEmployee(long id) {
        log.info("Start getting employee info where employee id {}",id);
        Optional<EmployeeEntity> optionalEmployeeEntity = empolyeeRepository.findById(id);

        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            log.info("Employee object is {}",employeeEntity);
            List<SalaryEntity> salaryEntityList = salaryRepository.findByFkEmployeeId(employeeEntity.getId());
            EmployeeRes employeeRes = new EmployeeRes();
            employeeRes.setEmployeeName(employeeEntity.getEmployeeName());
            employeeRes.setJobTitle(employeeEntity.getJobTitle());
            employeeRes.setJoinedDate(employeeEntity.getJoinedDate());
            employeeRes.setId(employeeEntity.getId());

            List<SalaryResponse> salaryResponseList = new ArrayList<>();
            salaryEntityList.stream().parallel().forEach(salaryEntity->{
                double tax = salaryEntity.getSalary() > 500 ?  0.1 : 0.2;
                salaryResponseList.add( new SalaryResponse(salaryEntity.getSalary(),(salaryEntity.getSalary()-salaryEntity.getSalary()*tax),tax));
            });

            employeeRes.setSalaryResponseList(salaryResponseList);
           /* for(int i=0;i<salaryEntityList.size();i++){
                SalaryEntity salaryEntity =   salaryEntityList.get(i);
                  double tax = salaryEntity.getSalary() > 500 ?  0.1 : 0.2;
                salaryResponseList.add( new SalaryResponse(salaryEntity.getSalary(),(salaryEntity.getSalary()-salaryEntity.getSalary()*tax),tax));
            }*/

            return new BaseResponse(200, "Employee exists", employeeRes);
        } else {
            log.error("Try to get user information for user id  {}", id);
            return new BaseResponse(400, "Employee not exists");
        }

    }


    public void deleteEmployee(long id) {
        empolyeeRepository.deleteById(id);
    }
    @Transactional
    public void updateEmployee(long id, String name) {
        EmployeeRes employeeRes = new EmployeeRes();
        employeeRes.setEmployeeName(name);

    }

    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = empolyeeRepository.findAll();
            EmployeeEntity employeeEntity = new EmployeeEntity();
            EmployeeRes employeeRes = new EmployeeRes();

            employeeRes.setEmployeeName(employeeEntity.getEmployeeName());
            employeeRes.setJobTitle(employeeEntity.getJobTitle());
            employeeRes.setJoinedDate(employeeEntity.getJoinedDate());

            return employeeEntities;
        }

}



