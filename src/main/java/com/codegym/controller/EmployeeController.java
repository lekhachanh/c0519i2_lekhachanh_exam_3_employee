package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.EmployeeForm;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    Environment env;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView listEmployee(@PageableDefault(page = 10, sort = "salary", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveEmployee(@ModelAttribute("employee") EmployeeForm employeeForm){
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload_file");
        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getName(),employeeForm.getBirthDate()
                , employeeForm.getAddress(), employeeForm.getSalary(), fileName);
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("message", "created new employee");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }
}
