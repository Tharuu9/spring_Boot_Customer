package lk.ijse.gdse.aad.spring_Boot_Customer.service;

import lk.ijse.gdse.aad.spring_Boot_Customer.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    public void saveOrder(OrderDTO dto);

    public void deleteOrder(String id);

    public void updateOrder(OrderDTO dto);

    public OrderDTO searchOrder(String id);

    public List<OrderDTO> getAllOrder();

}
