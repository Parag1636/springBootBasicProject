package com.learning.springBootBasicProject.Controllers;

import com.learning.springBootBasicProject.Entity.EmployeeEntity;
import com.learning.springBootBasicProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.findAll();
    }


    @GetMapping("id/{myId}")
    public ResponseEntity<EmployeeEntity> employeeEntityById(@PathVariable String myId){
        Optional<EmployeeEntity> employeeEntity = employeeService.findById(myId);
        if(employeeEntity.isPresent()){
            return new ResponseEntity<>(employeeEntity.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("{name}")
    public ResponseEntity<EmployeeEntity> createEmpById(@RequestBody EmployeeEntity employeeEntity, @PathVariable String name){
        try {
            employeeService.saveEmployee(employeeEntity, name);
            return new ResponseEntity<>(employeeEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("id/{name}/{myId}")
    public ResponseEntity<?> employeeEntityDeleteById(@PathVariable String myId, @PathVariable String name){
        if(myId != null && !myId.isEmpty()){
            employeeService.deleteById(myId, name);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("id/{name}/{myId}")
    public String employeeUpdateDeleteById(
            @PathVariable String myId,
            @RequestBody EmployeeEntity newEntity,
            @PathVariable String name)
    {
        EmployeeEntity old = employeeService.findById(myId).orElse(null);
        if(old != null){
            old.setName(newEntity.getName() != null && !newEntity.getName().equals("") ? newEntity.getName() : old.getName());



            old.setDepartment(newEntity.getDepartment() != null && !newEntity.getDepartment().equals("") ? newEntity.getDepartment() : old.getDepartment());
            employeeService.saveEmployee(old);
        }
        return "Updated";
    }
}
