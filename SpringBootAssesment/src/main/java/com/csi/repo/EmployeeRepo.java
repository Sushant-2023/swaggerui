package com.csi.repo;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    public Employee findByEmpContactNumber(long empContactnumber);

    public List<Employee> findByEmpName(String empName);

    public Employee findByEmpEmailId(String empEmailId);

    public void findByEmpSalary(double empSalary);




}
