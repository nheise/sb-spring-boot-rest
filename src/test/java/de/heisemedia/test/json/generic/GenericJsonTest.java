package de.heisemedia.test.json.generic;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;


/**
 * 
 */
public class GenericJsonTest {
    
    @Test
    public void testObjectWithGenericType() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor( ObjectWithGenericType.class );
        
        MappingIterator<ObjectWithGenericType<MyType>> mi = reader.readValues( "{\"attr\":\"value1\",\"genericAttr\":{\"myAttr\":\"value2\"}}" );
        ObjectWithGenericType<MyType> object = mi.next();
        
        Assert.assertThat( object.getAttr(), CoreMatchers.is( "value1" ) );
        //Assert.assertThat( object.getGenericAttr().getMyAttr(), CoreMatchers.is( "value2" ) );
    }

    @Test
    public void testObjectWithGenericMyType() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor( ObjectWithGenericMyType.class );
        
        MappingIterator<ObjectWithGenericMyType> mi = reader.readValues( "{\"attr\":\"value1\",\"genericAttr\":{\"myAttr\":\"value2\",\"mySubType\":{\"subTypeAttr\":\"value3\"}}}" );
        ObjectWithGenericMyType object = mi.next();
        
        Assert.assertThat( object.getAttr(), CoreMatchers.is( "value1" ) );
        Assert.assertThat( object.getGenericAttr().getMyAttr(), CoreMatchers.is( "value2" ) );
        Assert.assertThat( object.getGenericAttr().getMySubType().getSubTypeAttr(), CoreMatchers.is( "value3" ) );
    }

}
