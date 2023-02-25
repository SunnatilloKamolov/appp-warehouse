package uz.pdp.apppwarehouse.payload;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;
}
