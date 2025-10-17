package org.example.model;

import org.example.spi.Printable;
import org.example.util.MathHelper;

public class  Circle extends Shape implements Printable {
   public double radius;
    public Circle (double radius){
        super("Circle");
        this.radius = radius;
    }
    @Override
   public double area() {
        return MathHelper.round(MathHelper.PI * radius * radius, 2);
    }
    @Override
   public double perimeter() {
        return MathHelper.round(2 * MathHelper.PI * radius, 2);
    }
    @Override
   public void draw(){
        System.out.println("Drawing circle");
    }
    @Override
    public void printInfo() {
        System.out.println("Circle area = " + area());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle c = (Circle) o;
        return this.radius == c.radius;
    }
    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }
    @Override
    public String toString() {
        return name + " {Radius: " + radius + "}";
    }
}
