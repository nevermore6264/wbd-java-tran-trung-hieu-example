package com.codegym.controller;

import com.codegym.service.EmployeeService;
import com.codegym.model.Employee;
import com.codegym.model.Group;
import com.codegym.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private GroupService groupService;
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(GroupService groupService, EmployeeService employeeService) {
        this.groupService = groupService;
        this.employeeService = employeeService;
    }

//    @GetMapping("")
//    public ModelAndView getAllEmployees(Pageable pageable) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        Page<Employee> employees = employeeService.findAll(pageable);
//        modelAndView.setViewName("/employee/list");
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }

    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Employee> employees;
        if(s.isPresent()){
            employees = employeeService.findAllByNameContains(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @ModelAttribute("groups")
    public Page<Group> getAllGroup(Pageable pageable) {
        Page<Group> groups = groupService.findAll(pageable);
        return groups;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@ModelAttribute("employee") Employee employee) {

        ModelAndView modelAndView = new ModelAndView("/employee/create");

        employeeService.save(employee);
        modelAndView.addObject("message", "New employee is created");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return new ModelAndView("/error404");
        } else {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        }
    }

    @PostMapping("/{id}/edit")
    public ModelAndView updateEmployee(@Valid @ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        employeeService.save(employee);
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Employee is updated");
        return modelAndView;
    }


    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView;
        if (employee != null) {
            modelAndView = new ModelAndView("/employee/delete");
            modelAndView.addObject("employee", employee);
        } else {
            modelAndView = new ModelAndView("/error404");
        }
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        ModelAndView modelAndView;
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            employeeService.delete(id);
            modelAndView = new ModelAndView("redirect:/employees");
        } else {
            modelAndView = new ModelAndView("/error404");
        }

        return modelAndView;
    }
}
