package lk.ijse.gdse.aad.spring_Boot_Customer;

import lk.ijse.gdse.aad.spring_Boot_Customer.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ResponseUtil responseUtil() {
		return new ResponseUtil();
	}

}

