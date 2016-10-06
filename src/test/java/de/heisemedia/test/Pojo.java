package de.heisemedia.test;


import java.util.Map;


public class Pojo {

    private String name;

    private String[] directories;

    private Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap( Map<String, String> map ) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String[] getDirectories() {
        return directories;
    }

    public void setDirectories( String[] directories ) {
        this.directories = directories;
    }
}
