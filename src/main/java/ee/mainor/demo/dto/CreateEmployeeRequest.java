package ee.mainor.demo.dto;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String name;
    private Integer age;
    private Integer salary;
    private String position;
}
