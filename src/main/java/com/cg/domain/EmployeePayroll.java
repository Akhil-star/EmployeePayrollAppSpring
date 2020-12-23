package com.cg.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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
    private String startDate;
    private String note;
    private String profilePic;

   @ElementCollection
   private List<String> department;

    //    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
//    @Column(name = "department")

    public EmployeePayroll() {

    }

    public EmployeePayroll(String name,String salary, String gender, String startDate,  String note, String profilePic,  List<String> department) {
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