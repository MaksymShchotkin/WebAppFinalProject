package ee.mainor.demo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Integer price;

}

