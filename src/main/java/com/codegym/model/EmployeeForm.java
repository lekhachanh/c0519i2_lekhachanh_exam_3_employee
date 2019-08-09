package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class EmployeeForm {
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private Long salary;
    private MultipartFile avatar;

    public EmployeeForm() {
    }

    public EmployeeForm(int id, String name, LocalDate birthDate, String address, Long salary, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.salary = salary;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}