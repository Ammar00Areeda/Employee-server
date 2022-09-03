package com.sitech.employee.repository;

import com.sitech.employee.domain.entitiy.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpolyeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
