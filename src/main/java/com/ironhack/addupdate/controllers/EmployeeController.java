package com.ironhack.addupdate.controllers;

import com.ironhack.addupdate.dtos.EmployeePatchDTO;
import com.ironhack.addupdate.models.Employee;
import com.ironhack.addupdate.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee/add-new-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);

    }

    @PatchMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateStatus(@PathVariable int id, @RequestBody EmployeePatchDTO employeePatchDTO) {
        Employee exisitingEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException( HttpStatus.NOT_FOUND));

        if (employeePatchDTO.getStatus() != null) {
            exisitingEmployee.setStatus(employeePatchDTO.getStatus());
        }
        return employeeRepository.save(exisitingEmployee);

    }







}
