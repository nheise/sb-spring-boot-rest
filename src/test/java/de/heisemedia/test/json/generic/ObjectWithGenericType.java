package de.heisemedia.test.json.generic;


/**
 * 
 */
public class ObjectWithGenericType<T> {

    private String attr;
    
    private T genericAttr;

    public String getAttr() {
        return attr;
    }

    public void setAttr( String attr ) {
        this.attr = attr;
    }

    public T getGenericAttr() {
        return genericAttr;
    }

    public void setGenericAttr( T genericAttr ) {
        this.genericAttr = genericAttr;
    }

}
