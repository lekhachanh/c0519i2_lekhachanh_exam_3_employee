package com.codegym.service.impl;

import com.codegym.model.Department;
import com.codegym.model.Employee;
import com.codegym.repository.DepartmentRepository;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }


    @Override
    public void remove(Long id) {

        departmentRepository.delete(id);
    }

    @Override
    public Page<Department> findAllByNameContaining(String name, Pageable pageable) {
        return departmentRepository.findAllByNameContaining(name, pageable);
    }
}
