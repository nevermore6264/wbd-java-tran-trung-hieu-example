package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`group_employee`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_employee_id")
    private Long id;

    @Column(name = "group_employee_name")
    private String name;

    @Column(name = "group_employee_desc")
    private String desc;

    @OneToMany
    private transient List<Employee> employees;

    public Group() {
    }

    public Group(String name, String desc, List<Employee> employees) {
        this.name = name;
        this.desc = desc;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
