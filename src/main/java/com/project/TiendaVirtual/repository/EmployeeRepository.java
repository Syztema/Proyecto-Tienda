package com.project.TiendaVirtual.repository;

import com.project.TiendaVirtual.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //GENERA EL CRUD
}
