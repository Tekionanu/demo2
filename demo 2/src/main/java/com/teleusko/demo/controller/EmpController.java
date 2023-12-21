package com.teleusko.demo.controller;

import com.teleusko.demo.domain.Employee;
import com.teleusko.demo.repository.EmpRepo;
import com.teleusko.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpRepo empRepo;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmpById(@PathVariable String id) {
        return empRepo.findById(id);
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }

    @PostMapping
    public Employee createUser(@RequestBody Employee employee) {
        return empRepo.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable String id, @RequestBody Employee employee) {
        employee.setId(id);
        return empRepo.save(employee);
    }
    @GetMapping("/employees/byDepartment")
    public List<Employee> getEmployeesByDepartment(@RequestParam String department) {
        return employeeService.findByDepartment(department);
    }
    @GetMapping("/employees/bySalary")
    public List<Employee> getEmployeesBySalary(@RequestParam int salary) {
        return employeeService.findBySalary(salary);
    }
    @GetMapping("/employees/bySalaryAndDepartment")
    public List<Employee> getEmployeesBySalaryAndDepartment(
            @RequestParam int salary,
            @RequestParam String department
    ) {
        return employeeService.findBySalaryAndDepartment(salary, department);
    }

    @GetMapping("/emps")
    public List<Employee> getEmpByAge(@RequestParam int age){
        return employeeService.getEmployeesWithFilter(age);
    }


}


