package io.practise.Exception_Examples;

import java.io.IOException;

public class CompileTimeExceptionPropogation {
    public static void main(String args[]) {
        Integer a = 10;
        Integer b = 10;
        System.out.println(a ==b);
        System.out.println(a.hashCode() + " " + b.hashCode());

        String str1 = "ABC";
        String str2 = "ABC";
        System.out.println(str1 == str2);

       /* Emplyoyee emp1 = new Employee("A","B")

        Emplyoyee emp2 = new Employee("A","B")
*/

        CompileTimeExceptionPropogation obj = new CompileTimeExceptionPropogation();
        obj.p();
        System.out.println("normal flow");
    }

    // Rule: By default, Checked Exceptions are not forwarded in calling chain
    // (propagated).
    // and must be handled or declared
    void m() throws IOException {
        throw new IOException("device error");// checked exception
    }

    void n() {
        try {
            m();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("exception handeled");
        }
    }

}
class Employee {
    private String name;
    private String dept;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }
}