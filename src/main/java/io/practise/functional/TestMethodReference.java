package io.practise.functional;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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
    Supplier<LocalDateTime> test = () -> LocalDateTime.now();
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
}
