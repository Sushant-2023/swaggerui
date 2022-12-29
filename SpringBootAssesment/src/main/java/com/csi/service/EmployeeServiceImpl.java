package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee) {
        return employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDaoImpl.signIn(empEmailId, empPassword);
    }

    @Cacheable(value = "empId")
    public Optional<Employee> getDataById(int empId) {
        return employeeDaoImpl.getDataById(empId);
    }

    public Employee getDataByEmail(String empEmailId) {
        return employeeDaoImpl.getDataByEmail(empEmailId);
    }

    public Employee getDataByContactNumber(long empContactNumber) {
        return employeeDaoImpl.getDataByContactNumber(empContactNumber);
    }

    public List<Employee> getDataByName(String empName) {
        return employeeDaoImpl.getDataByName(empName);
    }

    public List<Employee> getDataByusingAnyInput(String input) {
        return employeeDaoImpl.getDataByUsingAnyInput(input);
    }

    public List<Employee> getAllData() {
        return employeeDaoImpl.getAlldata();
    }

    public List<Employee> sortByName() {
        return employeeDaoImpl.sortByName();
    }

    public List<Employee> sortById() {
        return employeeDaoImpl.sortById();
    }

    public List<Employee> sortBySalary() {
        return employeeDaoImpl.sortBySalary();
    }

    public List<Employee> sortByDOB() {
        return employeeDaoImpl.sortByDOB();
    }

    public List<Employee> filterDataBySalary(double empSalary) {
        return employeeDaoImpl.filterDataByEmpSalary(empSalary);
    }

    public boolean isEligibleForLoan(int empId) {
        return employeeDaoImpl.isEligibleForLoan(empId);
    }

    public List<Employee> sortByAge() {
        return employeeDaoImpl.sortByAge();
    }

    public Employee updateData(Employee employee) {
        return employeeDaoImpl.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDaoImpl.detleteDataById(empId);
    }

    public Optional<Employee> fetchSecondHighest(double empSalary) {
        return employeeDaoImpl.fetchSecondHighest(empSalary);
    }

    public void deleteAllData() {
        employeeDaoImpl.deleteAllData();
    }


}