package org.example.app;


import org.example.model.Circle;
import org.example.model.Rectangle;
import org.example.model.Triangle;
import org.example.model.Shape;
import org.example.model.Color;

import org.example.model.DetailLevel;

import org.example.spi.Printable;

import java.util.Scanner;

public class Main {
    static final class Logger {
       private Logger () {};
        public static void info(String msg) {System.out.println("[INFO] " + msg);}
        public static void warn(String msg) {System.out.println("[WARN] " + msg);}
        public static void error(String msg) {System.err.println("[ERROR] " + msg);}
    }

    static void demoLocal(Shape shape){
        class ShapePrinter implements Printable {
           Shape s;
           ShapePrinter(Shape s){this.s = s;}
            @Override
            public void printInfo() {System.out.println("Shape -> "+ s.toString());}
        }
        new ShapePrinter(shape).printInfo();
    }
    static void demoAnonymous(Shape shape){
        Printable anon = new Printable(){
            @Override
            public void printInfo(){
                System.out.println("Anonymous print -> "+ shape.getName());
            }
        };
        anon.printInfo();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] figures = new Shape[100];
        int count = 0;
        boolean isRun = true;
        boolean first = true;
        DetailLevel levelDetail = null;
        Logger.info("Welcome to Shape Studio!");

        do {
            System.out.println("Select level detail:");
            for (DetailLevel d : DetailLevel.values()) {
                System.out.println(d.getLevel() + " " + d.getLabel());
            }
            while (!sc.hasNextInt()) {
                Logger.error("Enter number:");
                sc.next();
            }
            int level = sc.nextInt();
            switch (level) {
               case  1 -> {levelDetail = DetailLevel.SHORT;
                    isRun = false;}
               case  2 -> {levelDetail = DetailLevel.FULL;
                    isRun = false;}
                default -> Logger.error("Enter not valid, please repeat");
            }
        } while (isRun);

        do {
            isRun = true;
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
               Logger.info("Right now figure in list: " + count + "\n");
            }
            System.out.println("1 - Circle\n2 - Rectangle\n3 - Triangle\n0 - Exit");
            while (!sc.hasNextInt()) {
                Logger.error("Enter number 0-3 :");
                sc.next();
            }
            int num = sc.nextInt();
            Color color = null;
            switch (num) {
                case 1 -> {
                    System.out.println("New Circle\nEnter radius:");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double r = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Radius save. Enter color:");
                    boolean work = true;
                    String stringColor;
                    while (work) {
                        for(Color c: Color.values()) {
                            System.out.println("- " + c.getLabel());
                        }
                        stringColor = sc.nextLine().toUpperCase();
                        switch (stringColor) {
                            case "RED", "BLACK", "YELLOW", "BLUE", "GREEN" -> {
                                color = Color.valueOf(stringColor);
                                work = false;
                                break;
                            }
                            default -> Logger.error("Enter not valid, please repeat");
                        }

                    }
                    figures[count] = new Circle(r, color);
                    count++;
                    Logger.info("Figure added.");
                }
                case 2 -> {
                    System.out.println("New Rectangle\nEnter width:");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double width = sc.nextDouble();
                    System.out.println("Enter height");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double height = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Side save. Enter color:");
                    boolean work = true;
                    String stringColor;
                    while (work) {
                        for(Color c: Color.values()) {
                            System.out.println("- " + c.getLabel());
                        }
                        stringColor = sc.nextLine().toUpperCase();
                        switch (stringColor) {
                            case "RED", "BLACK", "YELLOW", "BLUE", "GREEN" -> {
                                color = Color.valueOf(stringColor);
                                work = false;
                                break;
                            }
                            default -> Logger.error("Enter not valid, please repeat");
                        }

                    }
                    figures[count] = new Rectangle(width, height, color);
                    count++;
                    Logger.info("Figure added.");
                }
                case 3 -> {
                    System.out.println("New Triangle\nEnter side A:");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double sideA = sc.nextDouble();
                    System.out.println("Enter side B:");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double sideB = sc.nextDouble();
                    System.out.println("Enter side C:");
                    while (!sc.hasNextDouble()) {
                        Logger.error("Enter number:");
                        sc.next();
                    }
                    double sideC = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Side save. Enter color:");
                    boolean work = true;
                    String stringColor;
                    while (work) {
                        for(Color c: Color.values()) {
                            System.out.println("- " + c.getLabel());
                        }
                        stringColor = sc.nextLine().toUpperCase();
                        switch (stringColor) {
                            case "RED", "BLACK", "YELLOW", "BLUE", "GREEN" -> {
                                color = Color.valueOf(stringColor);
                                work = false;
                                break;
                            }
                            default -> Logger.error("Enter not valid, please repeat");
                        }

                    }
                    figures[count] = new Triangle(sideA, sideB, sideC,color);
                    count++;
                    Logger.info("Figure added.");
                }
                case 0 -> {
                    isRun = false;
                    first = false;
                    continue;
                }
                default -> {
                    Logger.error("Number out of range. Please re-enter");
                    continue;
                }
            }
            boolean addFigure = false;
            first = false;
            do {
                System.out.println("What do you want?\n1 - Add figure\n2 - Calculate area\n3 - Calculate perimeter\n4 - Print Info\n5 - Print Circle\n6 - Print Info taking into account detail level\n7 - demoAnonymous\n8 - demoLocal\n0 - Exit");
                while (!sc.hasNextInt()) {
                    Logger.error("Enter number 0-8:");;
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
                    case 5 -> {
                        for (Shape figure : figures)
                            if(figure instanceof Circle){
                               System.out.println(figure);
                            }

                    }
                    case 6 -> {
                         {
                             for (int i = 0; i < count; i++)
                            System.out.println(levelDetail.format(figures[i]));
                        }
                    }
                    case 7 -> {
                        for (int i = 0; i < count; i++){
                            demoAnonymous(figures[i]);
                        }
                    }
                    case 8 -> {
                        for (int i = 0; i < count; i++){
                            demoLocal(figures[i]);
                        }
                    }

                    case 0 -> {
                        isRun = false;
                        addFigure = true;
                    }
                    default -> {
                        Logger.error("Number out of range. Please re-enter");
                        continue;
                    }
                }
            } while (!addFigure);

        } while (isRun);
        System.out.println("See you later!");
        sc.close();
    }
}