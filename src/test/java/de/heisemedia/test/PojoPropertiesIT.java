package de.heisemedia.test;


import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( classes = PojoPropertiesIT.class )
@Configuration
@EnableConfigurationProperties( PojoProperties.class )
public class PojoPropertiesIT {
    
    @Autowired
    private PojoProperties pojoProperties;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getHelloFromProperties() throws Exception {
        Assert.assertThat( pojoProperties.getName(), CoreMatchers.is( "Hello" ) );
    }
    
    @Test
    public void getDirectoriesFromProperties() throws Exception {
        String[] directories = pojoProperties.getDirectories();
        Assert.assertThat( directories[0].toString(), CoreMatchers.is( "target/test-classes/dir1" ) );
    }
    
    @Test
    public void getMapFromProperties() throws Exception {
        Map<String, String> map = pojoProperties.getMap();
        Assert.assertThat( map.size(), CoreMatchers.is( 3 ) );
        Assert.assertThat( map.get( "key1" ), CoreMatchers.is( "value1" ) );
        Assert.assertThat( map.get( "key2" ), CoreMatchers.is( "value2" ) );
        Assert.assertThat( map.get( "key_\\d.*.csv" ), CoreMatchers.is( "tag-topic-200" ) );
    }
}