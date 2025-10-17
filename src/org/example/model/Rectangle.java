package org.example.model;

import org.example.util.*;

import org.example.spi.Printable;

public class Rectangle extends Shape implements Printable {
   public double width;
   public double height;

   public Rectangle (double width, double height){
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    @Override
   public double area(){
        return MathHelper.round(width * height, 2);
    }
    @Override
   public double perimeter(){
        return MathHelper.round(2 * (width + height), 2);
    }
    @Override
   public void draw(){
        System.out.println("Drawing rectangle");
    }
    @Override
    public void printInfo(){
        System.out.println("Rectangle area = " + area());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle r = (Rectangle) o;
        return (this.width == r.width && this.height == r.height)
                || (this.width == r.height && this.height == r.width);
        // порядок сторон не важен при сравнении фигур
    }
    @Override
    public int hashCode() {
       int result = 11;
       int w = Double.hashCode(width);
       int h = Double.hashCode(height);
       result = w + h + 31 * result;
       return result;
    }
    @Override
    public String toString() {
       return name + " {Width: " + width + " Height: " + height + "}";
    }
}
