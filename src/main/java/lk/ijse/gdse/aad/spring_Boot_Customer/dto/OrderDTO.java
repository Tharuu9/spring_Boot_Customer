package lk.ijse.gdse.aad.spring_Boot_Customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String orderID;
    private String orderDate;
    private double value;
    private String customerID;
}
