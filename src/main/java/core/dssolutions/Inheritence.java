package core.dssolutions;

public class Inheritence {

    static class A {
        int data;
        public A(){
            System.out.println("A Constructor");
        }
        public A(int data){
            System.out.println("A Data Constructor");
            this.data = data;
        }

        public void printData(){
            System.out.println(data);
        }
    }

    static class B extends A {
        int data;
        public B(){
            System.out.println("B Constructor");
        }
        public B(int data){
            //super(data);
            System.out.println("B data constructor");
            this.data = data;
        }

    }

  public static void main(String[] args) {
      A a = new B(3);
     //B b = (B) new A(5);

      a.printData();
    }
}