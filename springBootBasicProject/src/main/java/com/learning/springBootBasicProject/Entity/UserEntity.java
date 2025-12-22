package com.learning.springBootBasicProject.Entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user_data")
public class UserEntity {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String name;

    @NonNull
    private String password;

    @DBRef
    private List<EmployeeEntity> employeeEntities = new ArrayList<>();

    private List<String> roles;

}
