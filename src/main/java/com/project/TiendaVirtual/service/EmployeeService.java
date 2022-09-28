package com.project.TiendaVirtual.service;

import com.project.TiendaVirtual.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
