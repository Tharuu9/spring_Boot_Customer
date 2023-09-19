package lk.ijse.gdse.aad.spring_Boot_Customer.controller;
import lk.ijse.gdse.aad.spring_Boot_Customer.dto.CustomerDTO;
import lk.ijse.gdse.aad.spring_Boot_Customer.service.CustomerService;
import lk.ijse.gdse.aad.spring_Boot_Customer.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers(){
        return new ResponseUtil(200,"OK",customerService.getAllCustomer());
    }

    @ResponseStatus(HttpStatus.CREATED)//201

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customer){

        customerService.saveCustomer(customer);
        return new ResponseUtil(200,"Save..!",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer){
        customerService.updateCustomer(customer);
        return new ResponseUtil(200,"Updated..!",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"Deleted..!",null);
    }

    @GetMapping(path = "/id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id){
        return new ResponseUtil(200,"OK",customerService.searchCustomer(id));
    }
}
