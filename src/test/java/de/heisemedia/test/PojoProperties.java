package de.heisemedia.test;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="pojo")
public class PojoProperties extends Pojo {

}
