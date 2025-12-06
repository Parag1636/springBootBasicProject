package com.learning.springBootBasicProject.Repositories;

import com.learning.springBootBasicProject.Entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {}
