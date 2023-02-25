package uz.pdp.apppwarehouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class InputDto {
    private Date date;
    private String factureNumber;
    private String code;
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
}
