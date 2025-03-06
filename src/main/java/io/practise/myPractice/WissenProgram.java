package io.practise.myPractice;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given the following data structure:
 * A Student class with the properties:
 * name (String)
 * subjects (List of Subject objects)
 * A Subject class with the properties:
 * subjectName (String)
 * marks (Integer)
 * Requirements:
 * Create four dummy students, each having a list of subjects along with their respective marks.
 * For each subject (e.g., Math, English, etc.), identify and print the top 3 students based on their marks in that subject.
 * Do it using stream api.
 */
public class WissenProgram {

    public static void main(String[] args) {

        Subject1 math1 = new Subject1("maths", 10);
        Subject1 math2 = new Subject1("maths", 12);
        Subject1 math3 = new Subject1("maths", 7);
        Subject1 math4 = new Subject1("maths", 4);

        Subject1 engLish1 = new Subject1("english", 10);
        Subject1 engLish2 = new Subject1("english", 13);
        Subject1 engLish3 = new Subject1("english", 17);
        Subject1 engLish4 = new Subject1("english", 6);

        Student1 student1 = new Student1("Rahul", Arrays.asList(engLish1, math1));
        Student1 student2 = new Student1("Priyesh", Arrays.asList(engLish2, math2));
        Student1 student3 = new Student1("Sourav", Arrays.asList(engLish3, math3));
        Student1 student4 = new Student1("Sachin", Arrays.asList(engLish4, math4));

        List<Student1> studentList = Arrays.asList(student1, student2, student3, student4);

        // System.out.println(studentList);

        //Top 3 based on English
        studentList.stream().sorted((o1, o2) -> -Integer.compare(
                o1.getSubjects().stream().filter(subject1 -> subject1.getName().equals("english")).collect(Collectors.toList()).get(0).getMarks(),
                o2.getSubjects().stream().filter(subject1 -> subject1.getName().equals("english")).collect(Collectors.toList()).get(0).getMarks()))
                .limit(3).forEach(System.out::println);

        //Top 3 based on Maths
        studentList.stream().sorted((o1, o2) -> -Integer.compare(
                o1.getSubjects().stream().filter(subject1 -> subject1.getName().equals("maths")).collect(Collectors.toList()).get(0).getMarks(),
                o2.getSubjects().stream().filter(subject1 -> subject1.getName().equals("maths")).collect(Collectors.toList()).get(0).getMarks()))
                .limit(3).forEach(System.out::println);




    }
}

class Student1 {
    private String name;
    private List<Subject1> subjects;

    public Student1(String name, List<Subject1> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject1> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student1{" + "name='" + name + '\'' + ", subjects=" + subjects + '}';
    }
}

class Subject1 {
    private String name;
    private int marks;

    public Subject1(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Subject1{" + "name='" + name + '\'' + ", marks=" + marks + '}';
    }
}
