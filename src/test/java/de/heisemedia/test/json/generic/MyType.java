package de.heisemedia.test.json.generic;


public class MyType {

    private String myAttr;

    private MySubType mySubType;

    public MySubType getMySubType() {
        return mySubType;
    }

    public void setMySubType( MySubType mySubType ) {
        this.mySubType = mySubType;
    }

    public String getMyAttr() {
        return myAttr;
    }

    public void setMyAttr( String myAttr ) {
        this.myAttr = myAttr;
    }

}
