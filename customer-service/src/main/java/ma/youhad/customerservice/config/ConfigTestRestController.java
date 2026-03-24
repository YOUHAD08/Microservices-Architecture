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
    @Value("${app.global.p1:default-value}")
    private String p1;
    @Value("${app.global.p2:default-value}")
    private String p2;
    @Value("${spring.datasource.url:default-value}")
    private String url;
    @Value("${spring.cloud.discovery.enabled:default-value}")
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
