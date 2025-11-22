package ma.youhad.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.youhad.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerServiceRestClient {
    @GetMapping(path = "/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "findCustomerByIdFallback")
    Customer findCustomerById(@PathVariable Long id);

    default Customer findCustomerByIdFallback(Long id, Exception e) {
        return new Customer().builder().id(id).name("unknown").email("unknown").build();
    }

}
