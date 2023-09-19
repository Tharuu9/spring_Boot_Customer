package lk.ijse.gdse.aad.spring_Boot_Customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    private String orderID;
    private String orderDate;
    private double value;
    @ManyToOne
    private Customer customer;
}
