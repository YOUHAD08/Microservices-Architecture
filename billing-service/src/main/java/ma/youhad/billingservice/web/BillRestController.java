package ma.youhad.billingservice.web;

import ma.youhad.billingservice.entities.Bill;
import ma.youhad.billingservice.feign.CustomerServiceRestClient;
import ma.youhad.billingservice.feign.InventoryServiceRestClient;
import ma.youhad.billingservice.repository.BillRepository;
import ma.youhad.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;

    @RequestMapping("/bills/{id}")
    public Bill getBillByID(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerServiceRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem ->
                productItem.setProduct(inventoryServiceRestClient.findProductById(productItem.getProductId()))
        );
        return bill;
    }
}
