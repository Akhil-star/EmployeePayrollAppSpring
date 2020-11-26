package com.cg.employeepayrollapp.controller;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeepayrollController {

    @RequestMapping(value = {"","/","/home"})
    public ResponseEntity<String> getEmployeeData(){
        return new ResponseEntity<String>("Get Response from server", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeeId(@PathVariable(value = "empId") int empId){
        return new ResponseEntity<String>("Get Response from server "+empId,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<String>("Created employee payroll data for  "+employeePayrollDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<String>("Updated employee payroll data for  "+employeePayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable(value = "empId") int empId){
        return new ResponseEntity<String>("Delete call success for id "+empId,HttpStatus.OK);
    }

}
