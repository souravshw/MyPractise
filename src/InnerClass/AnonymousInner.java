package InnerClass;
//class that have no name is known as anonymous inner class in java. It should be used if you have to override method of class or interface.

 abstract class Concrete {

     abstract void eat();

    void drink() {
        System.out.println("Drink pepsi Motto");
    }
}

interface Boy {

    void height();
}

class AnonymousInner {

    public static void main(String args[]) {
        Concrete p = new Concrete() {
            void eat() {
                System.out.println("Nice Fruits");
            }
        };
        p.eat();
        p.drink();

        Boy b = new Boy() {
            public void height() {
                System.out.println("I am Very tall.");
            }
        };
        b.height();
    }
}
