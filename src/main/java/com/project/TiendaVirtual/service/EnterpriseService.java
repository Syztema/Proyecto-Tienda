package com.project.TiendaVirtual.service;

import com.project.TiendaVirtual.model.Enterprise;

import java.util.List;

public interface EnterpriseService {

    List<Enterprise> getAllEnterprises();
    void saveEnterprise(Enterprise enterprise);
    Enterprise getEnterpriseById(long id);
    void deleteEnterpriseById(long id);
}
