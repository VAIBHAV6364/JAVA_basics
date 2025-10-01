class Shape3{
    public void area(){
        System.out.println("It is printing the Area");
    }
}

class Triangle3 extends Shape3{
    public void area(int b, int h){
        double area = 0.5 * b * h;
        System.out.println("The area of the triangle : "+area);
    }
}

class Circle extends Shape3{
    public void area(int r){
        double area = 3.14 * r * r;
        System.out.println("The area of the circle : "+area);
    }
}

public class Hierarchical_Inheritence {
    public static void main(String args[]) {
        // Creating objects
        Shape3 s = new Shape3();
        Triangle3 t = new Triangle3();
        Circle c = new Circle();

        // Calling methods
        s.area();            // From parent class
        t.area();            // From parent (inherited)
        t.area(10, 5);       // Triangle specific
        c.area();            // From parent (inherited)
        c.area(7);           // Circle specific
    }
}
