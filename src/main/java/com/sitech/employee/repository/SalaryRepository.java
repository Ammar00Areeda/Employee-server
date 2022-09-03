package com.sitech.employee.repository;

import com.sitech.employee.domain.entitiy.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryEntity,Long> {

    List<SalaryEntity> findByFkEmployeeId(long fkEmployeeId);
}
