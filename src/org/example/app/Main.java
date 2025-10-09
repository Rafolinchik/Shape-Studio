package org.example.app;

import org.example.spi.*;
import org.example.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] figures = new Shape[100];
        int count = 0;
        boolean isRun = true;
        boolean first = true;
        System.out.println("Welcome to Shape Studio!");
        do {
            if (count == figures.length - 1) {
                Shape[] news = new Shape[figures.length + 100];
                for (int l = 0; l < figures.length; l++) {
                    news[l] = figures[l];
                }
                figures = news;
            }
            if (first) {
                System.out.println("Add first figure for start:");
            } else {
                System.out.println("Right now figure in list: " + count + "\n");
            }
            System.out.println("1 - Circle\n2 - Rectangle\n3 - Triangle\n0 - Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Error. Enter number 0-3 :");
                sc.next();
            }
            int num = sc.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println("New Circle\nEnter radius:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    figures[count] = new Circle(sc.nextDouble());
                    count++;
                    System.out.println("Figure added.");
                }
                case 2 -> {
                    System.out.println("New Rectangle\nEnter width:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    double width = sc.nextDouble();
                    System.out.println("Enter height");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    double height = sc.nextDouble();
                    figures[count] = new Rectangle(width, height);
                    count++;
                    System.out.println("Figure added.");
                }
                case 3 -> {
                    System.out.println("New Triangle\nEnter side A:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    double sideA = sc.nextDouble();
                    System.out.println("Enter side B:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    double sideB = sc.nextDouble();
                    System.out.println("Enter side C:");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Error. Enter number:");
                        sc.next();
                    }
                    double sideC = sc.nextDouble();
                    figures[count] = new Triangle(sideA, sideB, sideC);
                    count++;
                    System.out.println("Figure added.");
                }
                case 0 -> {
                    isRun = false;
                    first = false;
                    continue;
                }
                default -> {
                    System.out.println("Number out of range. Please re-enter");
                    continue;
                }
            }
            boolean addFigure = false;
            first = false;
            do {
                System.out.println("What do you whant?\n1 - Add figure\n2 - Calculate area\n3 - Calculate perimeter\n4 - Print Info\n0 - Exit");
                while (!sc.hasNextInt()) {
                    System.out.println("Error. Enter number 0-4 :");
                    sc.next();
                }
                num = sc.nextInt();
                switch (num) {
                    case 1 -> {
                        addFigure = true;
                        continue;
                    }
                    case 2 -> {
                        for (int i = 0; i < count; i++) {
                            double area = figures[i].area();
                            System.out.println("Area " + figures[i].getName() + " = " + area);
                        }
                    }
                    case 3 -> {
                        for (int i = 0; i < count; i++) {
                            double perimeter = figures[i].perimeter();
                            System.out.println("Perimeter " + figures[i].getName() + " = " + perimeter);
                        }
                    }
                    case 4 -> {
                        for (int i = 0; i < count; i++) {
                            Printable print = (Printable) figures[i];
                            print.printInfo();
                        }
                    }
                    case 0 -> {
                        isRun = false;
                        addFigure = true;
                    }
                    default -> {
                        System.out.println("Number out of range. Please re-enter");
                        continue;
                    }
                }
            } while (!addFigure);

        } while (isRun);
        System.out.println("See you later!");
        sc.close();
    }
}