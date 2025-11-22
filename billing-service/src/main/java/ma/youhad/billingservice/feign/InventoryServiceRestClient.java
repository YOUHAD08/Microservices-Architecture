package ma.youhad.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.youhad.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceRestClient {
    @GetMapping(path = "/products/{id}")
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "findProductByIdFallback")
    Product findProductById(@PathVariable Long id);

    default Product findProductByIdFallback(Long id, Exception e) {
        return new Product().builder().id(id).name("unknown").price(0).quantity(0).build();
    }
}
