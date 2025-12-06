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


    @PostMapping
    public ResponseEntity<EmployeeEntity> createEmpById(@RequestBody EmployeeEntity employeeEntity){
        try {
            employeeService.saveEmployee(employeeEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> employeeEntityDeleteById(@PathVariable String myId){
        if(myId != null && !myId.isEmpty()){
            employeeService.deleteById(myId);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("id/{myId}")
    public String employeeUpdateDeleteById(@PathVariable String myId, @RequestBody EmployeeEntity newEntity){
        return "Updated";
    }
}
