package de.heisemedia.test.pojoproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="pojo")
public class PojoProperties extends Pojo {

}
