class Shape{
    public void area(){
        System.out.println("It is printing the Area");
    }
}

class Triangle extends Shape{
    public void area(int b, int h){
        double area = 0.5 * b * h;
        System.out.println("The area of the triangle : "+area);
    }
}

public class Single_Level_Inheritance {
    public static void main(String args[]) {
        //Shape s = new Triangle();  // ✅ Allowed (Parent reference → Child object)
        Triangle obj = new Triangle();
        obj.area();
        obj.area(10, 5);
    }
}
