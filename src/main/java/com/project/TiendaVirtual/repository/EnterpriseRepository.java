package com.project.TiendaVirtual.repository;

import com.project.TiendaVirtual.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    //GENERA EL CRUD
}
