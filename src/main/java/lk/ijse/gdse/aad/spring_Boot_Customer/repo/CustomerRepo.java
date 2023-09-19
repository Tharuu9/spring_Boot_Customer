package lk.ijse.gdse.aad.spring_Boot_Customer.repo;

import lk.ijse.gdse.aad.spring_Boot_Customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<Customer, String> {
    Customer getCustomerById(String id);
}
