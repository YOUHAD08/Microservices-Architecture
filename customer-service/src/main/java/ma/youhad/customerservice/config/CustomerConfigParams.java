package ma.youhad.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(
    @DefaultValue("default-x") String x,
    @DefaultValue("default-y") String y
    ){}
