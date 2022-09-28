package com.project.TiendaVirtual.controller;

import com.project.TiendaVirtual.model.Enterprise;
import com.project.TiendaVirtual.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /*@GetMapping("/")
    public String index(){
        return "index";
    }*/

    @GetMapping("/enterprise")
    public String viewHomePage(Model model){
        model.addAttribute("listEnterprises", enterpriseService.getAllEnterprises());
        return "home_enterprise";
    }

    @GetMapping("/showNewEnterpriseForm")
    public String showNewEnterpriseForm(Model model){
        //CREATE MODEL ATRIBUTE
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise", enterprise);
        return "new_enterprise";
    }

    @PostMapping("/saveEnterprise")
    public String saveEnterprise(@ModelAttribute("enterprise")Enterprise enterprise){
        //SAVING ENTERPRISES IN DB
        enterpriseService.saveEnterprise(enterprise);
        return "redirect:/enterprise";
    }

    @GetMapping("/showFormForUpdateEnterprise/{id}")
    public String showFormForUpdateEnterprise(@PathVariable(value = "id")long id, Model model){
        //GET ENTERPRISES FROM THE SERVICE
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        //SET ENTERPRISES AS A MODEL ATRIBUTE TO PRE-POPULATE THE FORM
        model.addAttribute("enterprise", enterprise);
        return "update_enterprise";
    }

    @GetMapping("/deleteEnterprise/{id}")
    public String deleteEnterprise(@PathVariable(value = "id")long id){
        //CALL DELETE ENTERPRISE METHOD
        this.enterpriseService.deleteEnterpriseById(id);
        return "redirect:/enterprise";
    }

}
