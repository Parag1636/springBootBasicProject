package com.learning.springBootBasicProject.Service;

import com.learning.springBootBasicProject.Entity.EmployeeEntity;
import com.learning.springBootBasicProject.Entity.UserEntity;
import com.learning.springBootBasicProject.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEmployee(EmployeeEntity employeeEntity, String name){
        try {
            UserEntity userByName = userService.findByName(name);
            EmployeeEntity saveEmployee = employeeRepository.save(employeeEntity);
            userByName.getEmployeeEntities().add(saveEmployee);
            //userByName.setName(null);
            userService.saveUser(userByName);
        } catch (Exception e) {
            throw new RuntimeException("An error occured while saving the entry. " + e);
        }
    }

    public void saveEmployee(EmployeeEntity employeeEntity){
        employeeRepository.save(employeeEntity);
    }

    public void deleteById(String myId, String name) {
        UserEntity userByName = userService.findByName(name);
        userByName.getEmployeeEntities().removeIf(x -> x.getId().equals(myId));
        userService.saveUser(userByName);
        employeeRepository.deleteById(myId);
    }

    public Optional<EmployeeEntity> findById(String myId) {
        return employeeRepository.findById(myId);
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }
}
