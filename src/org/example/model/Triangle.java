package org.example.model;

import org.example.util.*;

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
        double a = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return MathHelper.round(a, 2);
    }

    @Override
    public double perimeter() {
        return MathHelper.round(sideA + sideB + sideC, 2);
    }

    @Override
   public void draw() {
        System.out.println("Drawing triangle");
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle area = " + area());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle t = (Triangle) o;
        return this.sideA == t.sideA && this.sideB == t.sideB && this.sideC == t.sideC;
    }
    @Override
    public int hashCode(){
       int result = 11;
       result = 31 * result + Double.hashCode(sideA);
        result = 31 * result + Double.hashCode(sideB);
        result = 31 * result + Double.hashCode(sideC);
        return result;
    }
    @Override
    public String toString() {
       return name + " {Side A: " + sideA + " Side B: " + sideB + " Side C: " + sideC + "}";
    }

}