package com.project.TiendaVirtual.controller;

import com.project.TiendaVirtual.model.Employee;
import com.project.TiendaVirtual.model.User;
import com.project.TiendaVirtual.service.EmployeeService;
import com.project.TiendaVirtual.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    UserService userService;

    public EmployeeController(UserService userService){
        this.userService = userService;
    }
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            User user = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("user", user);
        }
        return "index";
    }

    @GetMapping("/employee")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "home_employee";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        //CREATE MODEL ATRIBUTE
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //SAVING EMPLOYEES IN DB
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/showFormForUpdateEmployee/{id}")
    public String showFormForUpdateEmployee(@PathVariable(value = "id")long id, Model model){
        //GET EMPLOYEES FROM THE SERVICE
        Employee employee = employeeService.getEmployeeById(id);
        //SET EMPLOYEES AS A MODEL ATRIBUTE TO PRE-POPULATE THE FORM
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id")long id){
        //CALL DELETE EMPLOYEE METHOD
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

}
