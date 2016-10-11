/*
 * This document contains trade secret data which are the property of
 * RatePAY GmbH, Berlin, Germany. Information contained herein must not be used,
 * copied or disclosed in whole or part unless permitted in writing by RatePAY GmbH. 
 * All rights reserved by RatePAY GmbH. 
 *
 * Copyright (C) 2011 RatePAY GmbH / Berlin / Germany
 */

package de.heisemedia.converter;


import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


/**
 * 
 */
public class CsvToJson {
    
    private ObjectMapper mapper = new ObjectMapper();

    public String toJsonArray( String csv ) throws JsonProcessingException, IOException {

        List<Map<?, ?>> data = csvToMap( csv );

        return mapToJsonArray( data );
    }
    
    public List<String> toJsonList( String csv ) throws JsonProcessingException, IOException {
        List<Map<?, ?>> data = csvToMap( csv );

        return mapToJsonList( data );
    }

    private List<String> mapToJsonList( List<Map<?, ?>> data ) throws JsonGenerationException, JsonMappingException, IOException {
        List<String> jsons = new ArrayList<>();
        
        for( Map<?, ?> object : data ) {
            jsons.add( createJsonString( object ) );
        }
        
        return jsons;
    }

    private String mapToJsonArray( List<Map<?, ?>> data ) throws JsonGenerationException, JsonMappingException, IOException {
        return createJsonString( data );
    }

    private String createJsonString( Object data ) throws IOException,
                                                            JsonGenerationException,
                                                            JsonMappingException {
        StringWriter stringWriter = new StringWriter();

        mapper.writeValue( stringWriter, data );

        return stringWriter.toString();
    }

    private List<Map<?, ?>> csvToMap( String csv ) throws JsonProcessingException, IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.readerFor( Map.class ).with( bootstrap ).readValues( csv );

        return mappingIterator.readAll();
    }

}
