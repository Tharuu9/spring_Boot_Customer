package lk.ijse.gdse.aad.spring_Boot_Customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String city;
    private String email;
}
