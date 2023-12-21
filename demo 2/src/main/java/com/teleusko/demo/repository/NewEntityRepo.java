package com.teleusko.demo.repository;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

///import java.util.Collection;

@Document(collection="new_Collection_entity")
@CompoundIndexes({@CompoundIndex(name = "name_age_salary_department_index",def = "{'name':1,'age':1,'salary':1,'department':1}")})
public class NewEntityRepo {
    //@Id
    //private String id;
    //private String name;
    ///private int age;
    //private  String department;
    //private int salary;


}
