package org.example.model;

public enum Color {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    BLACK("Black");

    private final String label;

    Color(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
