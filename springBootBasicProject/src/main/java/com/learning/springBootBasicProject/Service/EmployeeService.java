package com.learning.springBootBasicProject.Service;

import com.learning.springBootBasicProject.Entity.EmployeeEntity;
import com.learning.springBootBasicProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(EmployeeEntity employeeEntity){
        employeeRepository.save(employeeEntity);
    }

    public void deleteById(String myId) {employeeRepository.deleteById(myId);}

    public Optional<EmployeeEntity> findById(String myId) {
        return employeeRepository.findById(myId);
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }
}
