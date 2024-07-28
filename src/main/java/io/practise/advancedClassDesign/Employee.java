package io.practise.advancedClassDesign;

public class Employee extends Object {

  private int empId;
  private String fName, lName;
  private int yearStarted;

  public Employee(int empId, String fName, String lName, int yearStarted) {
    this.empId = empId;
    this.fName = fName;
    this.lName = lName;
    this.yearStarted = yearStarted;
  }

  public static void main(String[] args) {
    Employee e1 = new Employee(1, "Sourav", "Sanu", 2016);
    Employee e2 = new Employee(2, "Surendra", "Chetry", 2013);
    Employee e3 = new Employee(3, "sagar", "zope", 2013);

    System.out.println(e1.equals(e2));
    System.out.println(e2.equals(e3));

    System.out.println(e1.toString());
  }

  public int hashcode() {
    return this.yearStarted + empId;
  }

  @Override
  public String toString() {
    return fName + lName + yearStarted;
  }

  @Override
  public boolean equals(Object obj) {
    return this.yearStarted == ((Employee) obj).yearStarted;
  }
}
