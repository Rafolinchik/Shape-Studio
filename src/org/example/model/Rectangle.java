package org.example.model;

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
        return width * height;
    }
    @Override
   public double perimeter(){
        return 2 * (width + height);
    }
    @Override
   public void draw(){
        System.out.println("Drawing rectangle");
    }
    @Override
    public void printInfo(){
        System.out.println("Rectangle area = " + area());
    }
}
