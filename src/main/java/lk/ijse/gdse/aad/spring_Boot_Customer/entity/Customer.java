package lk.ijse.gdse.aad.spring_Boot_Customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String city;
    private String email;
    @OneToMany(mappedBy = "customer",targetEntity = OrderDetails.class)
    private List<OrderDetails> orderDetails=new ArrayList<>();
}
