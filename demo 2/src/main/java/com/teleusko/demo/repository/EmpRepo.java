package com.teleusko.demo.repository;

import com.teleusko.demo.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends MongoRepository<Employee,String> {
   List<Employee> findByName(String name);
   List<Employee> findByAge(int age);
   List<Employee> findByNameAndAge(String name, int age);
   List<Employee>findBySalary(int salary);

   List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryAndDepartment(int salary, String department);

    List<Employee> findBySalaryGreaterThan(String department, int salary);
    @Query("{ 'department': ?0 }")
    //List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(int salary);



}
