package ee.mainor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Table(name = "employee")
public class Employee {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private Integer salary;
    private String position;

}
