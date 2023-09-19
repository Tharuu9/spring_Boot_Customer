package lk.ijse.gdse.aad.spring_Boot_Customer.service.impl;
import lk.ijse.gdse.aad.spring_Boot_Customer.dto.CustomerDTO;
import lk.ijse.gdse.aad.spring_Boot_Customer.entity.Customer;
import lk.ijse.gdse.aad.spring_Boot_Customer.repo.CustomerRepo;
import lk.ijse.gdse.aad.spring_Boot_Customer.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;
    @Autowired
    private  ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO){
        if (!repo.existsById(customerDTO.getId())){
            repo.save( mapper.map(customerDTO, Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }

    }
    @Override
    public void deleteCustomer(String id){
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Customer Already Exist...!");
        }

    }
    @Override
    public void updateCustomer(CustomerDTO customerDTO){
        if (repo.existsById(customerDTO.getId())) {
            repo.save(mapper.map(customerDTO,Customer.class));
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }

    }
    @Override
    public CustomerDTO searchCustomer(String id){
        if (repo.existsById(id)){
            Customer customer = repo.findById(id).get();
            return mapper.map(customer,CustomerDTO.class);
        }else {
            throw new RuntimeException("Customer NOT Exist...!");
        }
    }
    @Override
    public List<CustomerDTO> getAllCustomer(){
        List<Customer> all = repo.findAll();
      return mapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

}
