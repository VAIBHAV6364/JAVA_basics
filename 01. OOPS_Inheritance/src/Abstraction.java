abstract class Animal{
    abstract void walk();
}

class Horse extends Animal{
    public void walk(){
        System.out.println("Horse walks on four legs");
    }
}

class Chicken extends Animal{
    public void walk(){
        System.out.println("Chicken walks on two legs");
    }
}
public class Abstraction {
    public static void main(String args[]){
        Horse h = new Horse();
        h.walk();
        Chicken c = new Chicken();
        c.walk();
    }
}
