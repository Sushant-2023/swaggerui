package com.csi.controller;



import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")

public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee>signUp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean>signIn(@PathVariable String empEmailId,@PathVariable String empPassword){
        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }
    @GetMapping("/getDataById/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }
    @GetMapping("/getdatabyemail/{empEmailId}")
    public ResponseEntity<Employee>getDataByEmail(@PathVariable String empEmailId){
        return ResponseEntity.ok(employeeServiceImpl.getDataByEmail(empEmailId));
    }
    @GetMapping("/getdatabyusinganyinput/{input}")
    public ResponseEntity<List<Employee>>getDataByUsingAnyInput(@PathVariable String input){
        return ResponseEntity.ok(employeeServiceImpl.getDataByusingAnyInput(input));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){
     return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>>sortByName(){
      return ResponseEntity.ok(employeeServiceImpl.sortByName());
    }
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>>sortByid(){
        return ResponseEntity.ok(employeeServiceImpl.sortById());
    }
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>>sortBySalary(){
        return ResponseEntity.ok(employeeServiceImpl.sortBySalary());
    }
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>>sortByDOB(){
        return ResponseEntity.ok(employeeServiceImpl.sortByDOB());
    }
    @GetMapping("/filterdatabysalary{empSalary}")
    public ResponseEntity<List<Employee>>filterDataBySalry(@PathVariable double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.filterDataBySalary(empSalary));
    }
   @GetMapping("/fetchsecondhighestsalary{empSalary}")
   public ResponseEntity<Optional<Employee>>fetchSecondHighest(double empSalary){
        return ResponseEntity.ok(employeeServiceImpl.fetchSecondHighest(empSalary));
   }
    @GetMapping("/checkloaneligibility/{empId}")
    public ResponseEntity<String>isEligibleForLoan(@PathVariable int empId){
        String msg=null;
        if(employeeServiceImpl.isEligibleForLoan(empId)){
            msg="Eligible for loan";
        }else{
            msg="Not Eligible for Loan";
        }
        return ResponseEntity.ok(msg);

    }
    @GetMapping("/sortbyage")
    public ResponseEntity <List<Employee>>sortByAge(){
       return ResponseEntity.ok(employeeServiceImpl.sortByAge());

    }
    @PutMapping("/upadtedata/{empId}")
    public ResponseEntity<Employee>updateData(@PathVariable int empId,@RequestBody Employee employee){
        Employee employee1=employeeServiceImpl.getDataById(empId).orElseThrow(()->new RuntimeException("Employee Id Does not exist"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));
    }
    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity <String>deletDataById (@PathVariable int empId){
        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String>deleteAllData(){
          employeeServiceImpl.deleteAllData();
            return ResponseEntity.ok("All Data Deleted Successfully");
    }



}
