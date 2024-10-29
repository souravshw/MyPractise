package io.practise.functional;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import static org.junit.Assert.assertFalse;

public class TestMethodReference {

  @Test
  public void testFirstMethodReference() {
    Consumer<String> testConsumer = (name) -> System.out.print(name);
    testConsumer.accept("Sourav");
  }

  @Test
  public void testSecondMethodReference() {
    UnaryOperator<String> testSupplier = String::trim;
    System.out.println(testSupplier.apply("Test Second Method         "));
  }

  @Test
  public void testThirdMethodReference() {
    Supplier<LocalDateTime> test = LocalDateTime::now;
    System.out.println(test.get());
  }

  @Test
  public void testFourthMethodReference() {
    BiPredicate<Integer, String> testBipredicate = (a, b) -> b.equalsIgnoreCase(Integer.toString(a));
    System.out.println(testBipredicate.test(5, "5"));
  }

  @Test
  public void testFifthMethodReference() {
    Supplier<List<String>> testSupplier = () -> Arrays.asList("Hello", "World");
    testSupplier.get().forEach(a -> System.out.print(a));
  }

  @Test
  public void testSupplierRandom() {
    Supplier<Double> integerSupplier = Math::random;
    System.out.println(integerSupplier.get());
  }

  @Test
  public void testSystem() {
    System system = null;
    system.out.println("test");
  }

  @Test
  public void testPerson() {
    BiPredicate<Person, Person> isEquals = Person::equals;

    Person p1 = new Person();
    Person p2 = new Person();

    assertFalse(isEquals.test(p1, p2));
  }
}

class Student {
  private final String name = "student";

  public String getName() {
    return name;
  }
}

class Person {
  private String name;
  private int age;

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
}
