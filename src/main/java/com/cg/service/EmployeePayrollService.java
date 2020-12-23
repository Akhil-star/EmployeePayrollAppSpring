package com.cg.service;

import com.cg.domain.EmployeePayroll;
import com.cg.dto.EmployeePayrollDto;
import com.cg.exceptions.EmployeePayrollException;
import com.cg.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayrollDto CreateUser(EmployeePayrollDto employeePayrolldto) throws EmployeePayrollException {
        if (Objects.nonNull(employeePayrolldto.getName()) && Objects.nonNull(employeePayrolldto.getSalary()) && Objects.nonNull(employeePayrolldto.getGender()) && Objects.nonNull(employeePayrolldto.getStartDate())
            && Objects.nonNull(employeePayrolldto.getNote()) && Objects.nonNull(employeePayrolldto.getProfilePic()) &&
                Objects.nonNull(employeePayrolldto.getDepartment())) {
            EmployeePayroll employeePayroll = new EmployeePayroll(employeePayrolldto.getName(), employeePayrolldto.getSalary(),employeePayrolldto.getGender(),employeePayrolldto.getStartDate()
              ,employeePayrolldto.getNote(),employeePayrolldto.getProfilePic(),employeePayrolldto.getDepartment());
            return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }
        throw new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND);
    }

    public EmployeePayrollDto UpdateUser(EmployeePayrollDto employeePayrollDto) throws EmployeePayrollException {

        System.out.println(employeePayrollDto.toString());
        return employeePayrollRepository.findById(employeePayrollDto.getId()).map(employeePayroll -> {
            if(Objects.nonNull(employeePayrollDto.getName())){
                employeePayroll.setName(employeePayrollDto.getName());
            }
            if(Objects.nonNull(employeePayrollDto.getSalary())){
                employeePayroll.setSalary(employeePayrollDto.getSalary());
            }
            if(Objects.nonNull(employeePayrollDto.getGender())){
                employeePayroll.setGender(employeePayrollDto.getGender());
            }
            if(Objects.nonNull(employeePayrollDto.getStartDate())){
                employeePayroll.setStartDate(employeePayrollDto.getStartDate());
            }
            if(Objects.nonNull(employeePayrollDto.getNote())){
                employeePayroll.setNote(employeePayrollDto.getNote());
            }
            if(Objects.nonNull(employeePayrollDto.getProfilePic())){
                employeePayroll.setProfilePic(employeePayrollDto.getProfilePic());
            }
            if(Objects.nonNull(employeePayrollDto.getDepartment())){
                employeePayroll.setDepartment(employeePayrollDto.getDepartment());
            }
           return new EmployeePayrollDto(employeePayrollRepository.save(employeePayroll));
        }).orElseThrow(()-> new EmployeePayrollException( EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND));
    }

    public EmployeePayrollDto deleteUser(Long id) throws EmployeePayrollException {
        return employeePayrollRepository.findById(id).map(employeePayroll -> {
            employeePayrollRepository.deleteById(employeePayroll.getId());
            return new EmployeePayrollDto(employeePayroll);
        }).orElseThrow(()-> new EmployeePayrollException(EmployeePayrollException.ExceptionTypes.EMPLOYEE_NOT_FOUND));
    }

    public List<EmployeePayrollDto> getAllUser(){
        return employeePayrollRepository.findAll()
                .stream()
                .map(employeePayroll -> new EmployeePayrollDto(employeePayroll))
                .collect(Collectors.toList());
    }

    public Optional<EmployeePayroll> getById(long id) {
        System.out.println("in get");
        System.out.println(employeePayrollRepository.findById(id));
        return employeePayrollRepository.findById(id);
    }
}
