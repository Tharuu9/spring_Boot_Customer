package lk.ijse.gdse.aad.spring_Boot_Customer.repo;

import lk.ijse.gdse.aad.spring_Boot_Customer.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderDetails, String> {
    OrderDetails getOrderDetailsByOrderID(String id);
}
