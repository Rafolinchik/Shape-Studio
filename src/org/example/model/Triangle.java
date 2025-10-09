package org.example.model;

import org.example.spi.Printable;

public class Triangle extends Shape implements Printable {
   public double sideA;
   public double sideB;
   public double sideC;

   public Triangle(double sideA, double sideB, double sideC) {
        super("Triangle");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
   public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
   public void draw() {
        System.out.println("Drawing triangle");
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle area = " + area());
    }
}