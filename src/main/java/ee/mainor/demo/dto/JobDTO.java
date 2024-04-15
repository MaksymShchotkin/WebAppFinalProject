package ee.mainor.demo.dto;


import lombok.Data;

@Data
public class JobDTO {
    private Long id;
    private String name;
    private Integer age;
    private Integer salary;
}