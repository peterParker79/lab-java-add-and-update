package com.ironhack.addupdate.controllers;

import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee/add-new-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);

    }

}
