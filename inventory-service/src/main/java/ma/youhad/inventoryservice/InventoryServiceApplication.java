package ma.youhad.inventoryservice;

import ma.youhad.inventoryservice.entities.Product;
import ma.youhad.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().name("Smart Phone").price(1200).quantity(10).build());
            productRepository.save(Product.builder().name("Laptop").price(1500).quantity(3).build());
            productRepository.save(Product.builder().name("Washing Machine").price(1400).quantity(5).build());
            productRepository.save(Product.builder().name("Screen").price(1000).quantity(6).build());
            productRepository.save(Product.builder().name("Mouse").price(150).quantity(20).build());
        };
    }
}
