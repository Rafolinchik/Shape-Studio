package org.example.model;

public abstract class Shape {
    protected final String name;
    Shape (String name) {
        this.name = name;
    }
   public abstract double area();
    public abstract double perimeter();
    void draw(){
        System.out.println("Drawing shape...");
    }
    public String getName() {
        return name;
    }
}