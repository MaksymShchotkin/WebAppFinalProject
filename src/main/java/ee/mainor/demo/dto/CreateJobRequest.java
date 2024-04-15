package ee.mainor.demo.dto;

import lombok.Data;

@Data
public class CreateJobRequest {
    private String name;
    private Integer age;
    private Integer salary;
}
