package io.practise.myPractice;


import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestProgram {
    public static void main(String[] args) {

        List<Employee1> employeeList = new ArrayList();

        employeeList.add(new Employee1(108, "Katreena Kapoor", 33, "FEMALE", "Marketing & Sales", 2014, 45000.0));
        employeeList.add(new Employee1(109, "Lara Advani", 33, "FEMALE", "Tester", 2014, 40000.0));
        employeeList.add(new Employee1(110, "Sachin Jha", 33, "MALE", "Office Administration", 2012, 50000.0));
        employeeList.add(new Employee1(111, "Aaditya Raj", 30, "MALE", "Java Developer", 2014, 80000.0));
        employeeList.add(new Employee1(112, "Virat Patel", 25, "MALE", "Tester", 2019, 30000.0));
        employeeList.add(new Employee1(113, "Prashant Kishore", 28, "MALE", "Front end Developer", 2018, 40000.0));
        employeeList.add(new Employee1(114, "Shreya Kiki", 32, "FEMALE", "Java Developer", 2014, 60000.0));
        employeeList.add(new Employee1(115, "Julie Sharma", 30, "FEMALE", "HR", 2015, 60000.0));

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics collect = employeeList.stream().collect(Collectors.summarizingDouble(Employee1::getSalary));

        System.out.println(collect.getSum() + " " + collect.getAverage());

        //What is average salary of male & female employees?
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingDouble(Employee1::getSalary))));

        //System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingDouble(Employee1::getSalary))));

        employeeList.stream()
                .collect(Collectors.groupingBy(Employee1::getGender, Collectors.averagingDouble(Employee1::getSalary)))
                .forEach((s, sal) -> System.out.println(s + " " + sal));
    }
}

class Employee1 {
    int i;
    String name;
    int age;
    String gender;
    String domain;
    int year;
    double salary;

    public Employee1(int i, String julie_sharma, int i1, String gender, String hr, int i2, double v) {
        this.i = i;
        this.name = julie_sharma;
        this.age = i1;
        this.gender = gender;
        this.domain = hr;
        this.year = i2;
        this.salary = v;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "i=" + i +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", domain='" + domain + '\'' +
                ", year=" + year +
                ", salary=" + salary +
                '}';
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

