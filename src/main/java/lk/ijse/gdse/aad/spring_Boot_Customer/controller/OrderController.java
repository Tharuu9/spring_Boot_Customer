package lk.ijse.gdse.aad.spring_Boot_Customer.controller;

import lk.ijse.gdse.aad.spring_Boot_Customer.dto.OrderDTO;
import lk.ijse.gdse.aad.spring_Boot_Customer.service.OrderService;
import lk.ijse.gdse.aad.spring_Boot_Customer.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"OK",orderService.getAllOrder());
    }

    @ResponseStatus(HttpStatus.CREATED)//201

    @PostMapping(path = "/yo",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody OrderDTO orderDTO){
        System.out.println(orderDTO.toString());
        orderService.saveOrder(orderDTO);
        return new ResponseUtil(200,"Save..!",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody OrderDTO orderDTO){
        orderService.updateOrder(orderDTO);
        return new ResponseUtil(200,"Updated..!",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        orderService.deleteOrder(id);
        return new ResponseUtil(200,"Deleted..!",null);
    }

    @GetMapping(path = "/id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"OK",orderService.searchOrder(id));
    }
}
