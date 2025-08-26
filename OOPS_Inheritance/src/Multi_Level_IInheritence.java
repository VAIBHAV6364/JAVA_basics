class Shape2{
    public void area(){
        System.out.println("It is printing the Area");
    }
}

class Triangle2 extends Shape2{
    public void area(int b, int h){
        double area = 0.5 * b * h;
        System.out.println("The area of the triangle : "+area);
    }
}

class EquiLateralTriangle extends Triangle2{
    public void area(int b, int h){
        double area = 0.5 * b * h;
        System.out.println("The area of the equi triangle : "+area);
    }
}

public class Multi_Level_IInheritence {
    public static void main(String args[]) {
        //Shape s = new Triangle();  // ✅ Allowed (Parent reference → Child object)
        EquiLateralTriangle obj = new EquiLateralTriangle();
        Shape2 obj2 = new Triangle2();
        obj.area();
        ((Triangle2)obj2).area(20, 12);  // ✅ downcast to call overloaded method
        obj.area(10, 5);
    }
}
