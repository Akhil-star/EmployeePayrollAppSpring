package com.cg.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class EmployeePayroll implements Serializable {

    private static final long serialVersionUID = -8900492704842756948L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    public EmployeePayroll() {

    }

    public EmployeePayroll(String name,String salary, String gender, LocalDate startDate,  String note, String profilePic,  List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeePayroll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", gender='" + gender + '\'' +
                ", startDate=" + startDate +
                ", note='" + note + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", departments=" + department +
                '}';
    }
}