package com.cg.dto;


import com.cg.domain.EmployeePayroll;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDto {

    private Long id;
    @NotNull(message = "Please enter valid name")
    @NotEmpty(message = "Please enter valid name")
    @Pattern(regexp = "^[A-Z][a-z]{3,}",message="Enter the valid name")
    private String name;

    @Min(value = 500,message="Min wage is more than 500")
    private String salary;

    @Pattern(regexp = "male|female", message ="Gender needs to be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start date should not be empty")
    @PastOrPresent(message = "startDate should be past or todays date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;

    @NotNull(message = "Department should not be empty")
    private List<String> department;


    public EmployeePayrollDto(){

    }

    public EmployeePayrollDto(EmployeePayroll employeePayroll){
        this.id=employeePayroll.getId();
        this.name=employeePayroll.getName();
        this.salary=employeePayroll.getSalary();
        this.gender=employeePayroll.getGender();
        this.startDate=employeePayroll.getStartDate();
        this.note=employeePayroll.getNote();
        this.profilePic=employeePayroll.getProfilePic();
        this.department=employeePayroll.getDepartment();
    }



}
