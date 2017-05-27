/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocpPractise;

/**
 *
 * @author sanu
 */
public class InnerClasses {

    public class FirstInsideClass {

        int a = 9;

        public void printNum() {
            System.out.println(a);
        }
    }

    public void go() {
        FirstInsideClass in = new FirstInsideClass();
        in.printNum();
    }

    public static void main(String[] args) {
        InnerClasses in = new InnerClasses();
        in.go();

        for (characters c : characters.values()) {
            if (c.equals(characters.C)) {
                c.printSmallCase(); System.out.println(" Hi");
            } else {
                System.out.println(c.getCase());
            }
        }

    }

}
