package com.sitech.employee.domain.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_table")
public class EmployeeEntity {
    @Id
    @Column(name="id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "joined_date")
    private String joinedDate;

    @Column(name = "job_title")
    private String jobTitle;



}
