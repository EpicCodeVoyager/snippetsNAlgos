package core.dssolutions;

class someclass {
}

public class TestingCode {
    static int x;
    static int y;

    static int fun (){
        return ++x;
    }

    static int fun2 (){
        return y++;
    }

    static class  Base {
        public void Print() {
            System.out.println("Base");
        }
    }

    static class Derived extends Base {
        public void Print() {
            System.out.println("Derived");
        }
    }

    public static void DoPrint( Base o ) {
        o.Print();
    }

    public static void main(String[] args) {

    System.out.println(fun());
    System.out.println(fun());
    System.out.println(fun());

    System.out.println(fun2());
    System.out.println(fun2());
    System.out.println(fun2());

    System.out.println("y" + y);
    System.out.println("x" + x);

    Base x = new Base();
    Base y = new Derived();
    Derived z = new Derived();
    DoPrint(x);
    DoPrint(y);
    DoPrint(z);
    }
}
