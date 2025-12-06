package com.learning.springBootBasicProject.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "employee_data")
/*@Getter

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode*/
// If we use @Data then it is equal to getter, setter, allArgsConstructor, ToString, ToEqualsAndHashCode
@Data
@Setter
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    private String id;

    private String name;
    private String department;
    private Date timestamp = new Date();
}
