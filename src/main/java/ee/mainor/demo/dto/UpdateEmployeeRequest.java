package ee.mainor.demo.dto;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private String name;
    private String position;
    private Integer age;
    private Integer salary;
}
