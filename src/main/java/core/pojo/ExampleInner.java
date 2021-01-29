package core.pojo;

public class ExampleInner {
    private int field1;

    public ExampleInner(int field){
        this.field1 = field;
    }

    public ExampleInner(){
    }

    public void incrementField(){
//        field1++;
    }

    public void printField(){
    System.out.println(field1);
    }

    public static class InnerClass extends ExampleInner {
        private int field2;

        public InnerClass(int field){
            //super(field);
            // super(field);
            this.field2 = field;
        }

        public void method1(){
            while(field2>0){
                field2 = field2 -1;
                incrementField();
            }
        }

        public void printField(){
            System.out.println(super.field1 );
        }

    }
    public static void main(String[] args) {
        ExampleInner obj = new InnerClass(13);

        ((InnerClass) obj).method1();
        obj.printField();
    }
}
