package com.teleusko.demo.service;

import com.teleusko.demo.domain.Employee;
import com.teleusko.demo.repository.EmpRepo;
//import com.teleusko.demo.repository.NewEntityRepo;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    //@Autowired
    private EmpRepo empRepo;

    public List<Employee> getEmployeesByName(String name) {
        return empRepo.findByName(name);
    }

    public List<Employee> getEmployeesByAge(int age) {
        return empRepo.findByAge(age);
    }

    public List<Employee> getEmployeesByNameAndAge(String name, int age) {
        return empRepo.findByNameAndAge(name, age);
    }
    public List<Employee> findByDepartment(String department) {
        return empRepo.findByDepartment(department);

    }
    public List<Employee> findBySalaryGreaterThan(String department, int salary) {
        return empRepo.findBySalaryGreaterThan(department, salary);
    }
    public List<Employee> findBySalaryAndDepartment(int salary, String department) {
        return empRepo.findBySalaryAndDepartment(salary, department);
    }
    // In your service class
    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return empRepo.findBySalaryGreaterThan(salary);
    }




    @Autowired
    MongoTemplate mongoTemplate;

    public List<Employee> getEmployeesWithFilter(int age) {
        Criteria criteria = Criteria.where("age").gte(age);
        Query query = new Query(criteria);

        return mongoTemplate.find(query, Employee.class);

    }


    public List<Employee> findBySalary(int salary) {
        return empRepo.findBySalary(salary);
    }
}
