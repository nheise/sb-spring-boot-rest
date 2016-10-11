
package de.heisemedia.converter;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;


public class CsvToJsonTest {

    private CsvToJson csvToJson = new CsvToJson();

    @Test
    public void testToJsonArrayArrayConverter() throws Exception {
        String csv = "HEADER1,HEADER2\n\"value11\",\"value12\"\n\"value21\",\"value22\"";

        String json = csvToJson.toJsonArray( csv );

        assertThat( json, is( "[{\"HEADER1\":\"value11\",\"HEADER2\":\"value12\"},{\"HEADER1\":\"value21\",\"HEADER2\":\"value22\"}]" ) );

    }

    @Test
    public void testToJsonArrayListConverter() throws Exception {
        String csv = "HEADER1,HEADER2\n\"value11\",\"value12\"\n\"value21\",\"value22\"";

        List<String> json = csvToJson.toJsonList( csv );

        assertThat( json.size(), CoreMatchers.is( 2 ) );
        assertThat( json.get( 0 ), is( "{\"HEADER1\":\"value11\",\"HEADER2\":\"value12\"}" ) );
        assertThat( json.get( 1 ), is( "{\"HEADER1\":\"value21\",\"HEADER2\":\"value22\"}" ) );

    }

}
