package org.example.model;

public enum DetailLevel {
    SHORT(1, "Basic") {
        @Override public String format(Shape s){
            return s.name;
        }
    },
    FULL(2, "Detail") {
        @Override public String format(Shape s){
            if(s instanceof Rectangle) {
                Rectangle.Metrics m = ((Rectangle) s).metrics();
                return s.name + ":\nArea = " + s.area() + "\nPerimeter = "+ s.perimeter() + "\nDiagonal = " + m.diagonal() + "\nAspect Ratio = " + m.aspectRatio();
            }
            return s.name + ":\nArea = " + s.area() + "\nPerimeter = "+ s.perimeter();
        }
    };

    private final int level;
    private final String label;

    DetailLevel(int level, String label){
        this.level = level;
        this.label = label;
    }

    public int getLevel() {return level;};
    public String getLabel() {return label;};
    public abstract String format(Shape s);


}
