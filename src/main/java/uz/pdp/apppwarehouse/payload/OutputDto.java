package uz.pdp.apppwarehouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OutputDto {
    private Timestamp date;
    private String factureNumber;
    private String code;
    private Integer warehouseId;
    private Integer currencyId;
    private Integer clientId;


}
