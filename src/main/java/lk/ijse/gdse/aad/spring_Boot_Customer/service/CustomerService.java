package lk.ijse.gdse.aad.spring_Boot_Customer.service;


import lk.ijse.gdse.aad.spring_Boot_Customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public void updateCustomer(CustomerDTO dto);

    public CustomerDTO searchCustomer(String id);

    public List<CustomerDTO> getAllCustomer();

}
