package de.heisemedia.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class IfrTest {
    
    private static final List<String> NOTES_NAMES = Arrays.asList( "C  ", "   ", "D  ", "   ", "E  ", "F  ", "   ", "G  ", "   ", "A  ", "   ", "B  ",
                                                                   "c  ", "   ", "d  ", "   ", "e  ", "f  ", "   ", "g  ", "   ", "a  ", "   ", "b  ",
                                                                   "c' ", "   ", "d' ", "   ", "e' ", "f' ", "   ", "g' ", "   ", "a' ", "   ", "b' ",
                                                                   "c''", "   ", "d''", "   ", "e''", "f''", "   ", "g''", "   ", "a''", "   ", "b''");
    private static final List<String> NOTES = Arrays.asList( "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  ",
                                                             "1  ", "   ", "2  ", "   ", "3  ", "4  ", "   ", "5  ", "   ", "6  ", "   ", "7  " );
    
    private static final List<String> ROOT0 = Arrays.asList();
    private static final List<String> ROOT1 = Arrays.asList( "1", "3", "5", "7" );
    private static final List<String> ROOT2 = Arrays.asList( "2", "4", "6", "1" );
    private static final List<String> ROOT3 = Arrays.asList( "3", "5", "7", "2" );
    private static final List<String> ROOT4 = Arrays.asList( "4", "6", "1", "3" );
    private static final List<String> ROOT5 = Arrays.asList( "5", "7", "2", "4" );
    private static final List<String> ROOT6 = Arrays.asList( "6", "1", "3", "5" );
    private static final List<String> ROOT7 = Arrays.asList( "7", "2", "4", "6" );
    
    
    @Test
    public void ifr() throws Exception {
        int offset = 4;
        createFretboard( offset, ROOT0, NOTES );
        System.out.println();
        createFretboard( offset, ROOT0, NOTES_NAMES );
    }

    private void createFretboard( int offset, List<String> root, List<String> notes ) {
        createStringFromNotes( offset + 24, root, notes );
        createStringFromNotes( offset + 19, root, notes );
        createStringFromNotes( offset + 15, root, notes );
        createStringFromNotes( offset + 10, root, notes );
        createStringFromNotes( offset + 5, root, notes );
        createStringFromNotes( offset + 0, root, notes );
    }

    private void createStringFromNotes( int offest, List<String> root, List<String> notes ) {
        StringBuffer buffer = new StringBuffer();
        int toIndex = offest + 15;
        for( String note : notes.subList( offest, toIndex < notes.size() ? toIndex : notes.size() ) ) {
            buffer.append( "|" ).append( root.isEmpty() || root.contains( note ) ? note : " " );
        }
        System.out.println( buffer.toString() );
    }

}
