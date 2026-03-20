package ma.youhad.customerservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.cloud.discovery.enabled}")
    private String enabled;

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/testConfig1")
    public Map<String,String> configTest(){
        return Map.of("p1",p1,"p2",p2);
    }

    @GetMapping("/testConfig2")
    public CustomerConfigParams configTest2(){
        return customerConfigParams;
    }

    @GetMapping("/testConfig3")
    public Map<String,String> configTest3(){
        return Map.of("url",url,"enabled",enabled);
    }

}
