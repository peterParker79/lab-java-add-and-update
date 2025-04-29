package com.ironhack.addupdate.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private int employeeId;
    @NotEmpty("El departamento no puede estar vacío!")
    @Enumerated(EnumType.STRING)
    Department department;
    @NotEmpty("El nombre no puede estar vacío!")
    String name;

    @NotEmpty("El estado no puede ser vacío!")
    @Enumerated(EnumType.STRING)
    Status status;

    public Employee() {
    }

    public Employee(Department department, String name, Status status) {


        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department=" + department +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
