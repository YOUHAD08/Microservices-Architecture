package ma.youhad.customerservice;

import ma.youhad.customerservice.entities.Customer;
import ma.youhad.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Ayoub").email("Ayoub@gmail.com").build());
            customerRepository.save(Customer.builder().name("Salwa").email("Salwa@gmail.com").build());
            customerRepository.save(Customer.builder().name("Amin").email("Amin@gmail.com").build());
        };
    }
}