package org.example.model;

import org.example.spi.Printable;

public class  Circle extends Shape implements Printable {
   public double radius;
    public Circle (double radius){
        super("Circle");
        this.radius = radius;
    }
    @Override
   public double area() {
        return Math.PI * radius * radius;
    }
    @Override
   public double perimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
   public void draw(){
        System.out.println("Drawing circle");
    }
    @Override
    public void printInfo() {
        System.out.println("Circle area = " + area());
    }
}
