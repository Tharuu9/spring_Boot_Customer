package lk.ijse.gdse.aad.spring_Boot_Customer.service.impl;

import lk.ijse.gdse.aad.spring_Boot_Customer.dto.OrderDTO;
import lk.ijse.gdse.aad.spring_Boot_Customer.entity.Customer;
import lk.ijse.gdse.aad.spring_Boot_Customer.entity.OrderDetails;
import lk.ijse.gdse.aad.spring_Boot_Customer.repo.CustomerRepo;
import lk.ijse.gdse.aad.spring_Boot_Customer.repo.OrderRepo;
import lk.ijse.gdse.aad.spring_Boot_Customer.service.OrderService;
import lk.ijse.gdse.aad.spring_Boot_Customer.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    ResponseUtil responseUtil;
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void saveOrder(OrderDTO dto) {
        if (!repo.existsById(dto.getOrderID())){
            Customer customer = mapper.map(customerRepo.getCustomerById(dto.getCustomerID()), Customer.class);
            if (customer!=null){
                repo.save( mapper.map(dto, OrderDetails.class));
            }else {
                throw new RuntimeException("Customer Does Not Exist...!");
            }
        }else {
            throw new RuntimeException("Order Already Exist...!");
        }
//        if (searchOrder(dto.getOrderID())==null) {
//            OrderDTO orderDTO = searchOrder(dto.getOrderID());
//            OrderDetails order = mapper.map(orderDTO, OrderDetails.class);
//            Customer customer = mapper.map(customerRepo.getCustomerById(dto.getCustomerID()), Customer.class);
//            if (customer==null){
//                throw new RuntimeException("Customer Does Not Exist...!");
//            }else {
//                order.setCustomer(customer);
//                repo.save(order);
//            }
//            /*repo.save( mapper.map(dto, OrderDetails.class));*/
//        }else {
//            throw new RuntimeException("Order Already Exist...!");
//        }
    }

    @Override
    public void deleteOrder(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("Order Already Exist...!");
        }
    }

    @Override
    public void updateOrder(OrderDTO dto) {
        if (repo.existsById(dto.getOrderID())) {
            repo.save(mapper.map(dto,OrderDetails.class));
        }else {
            throw new RuntimeException("Order NOT Exist...!");
        }
    }

    @Override
    public OrderDTO searchOrder(String id) {
        if (repo.existsById(id)){
            OrderDetails orderDetails = repo.findById(id).get();
            return mapper.map(orderDetails, OrderDTO.class);
        }else {
            throw new RuntimeException("Order NOT Exist...!");
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<OrderDetails> all = repo.findAll();
        return mapper.map(all,new TypeToken<List<OrderDTO>>(){}.getType());

    }
}
