package com.learning.springBootBasicProject.Repositories;

import com.learning.springBootBasicProject.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Object> {

    UserEntity findByName(String name);

}
