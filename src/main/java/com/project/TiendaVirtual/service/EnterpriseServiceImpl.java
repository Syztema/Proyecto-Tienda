package com.project.TiendaVirtual.service;

import com.project.TiendaVirtual.model.Enterprise;
import com.project.TiendaVirtual.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService{
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    @Override
    public void saveEnterprise(Enterprise enterprise) {
        this.enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        Optional<Enterprise> optional = enterpriseRepository.findById(id);
        Enterprise enterprise = null;
        if(optional.isPresent()){
            enterprise = optional.get();
        } else {
            throw new RuntimeException("Empresa no Encontrada para el Id: " + id);
        }
        return enterprise;
    }

    @Override
    public void deleteEnterpriseById(long id) {
        this.enterpriseRepository.deleteById(id);
    }
}
