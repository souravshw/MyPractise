package io.practise.functional;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class TestMethodReference {

  @Test
  public void testFirstMethodReference() {
    Consumer<String> testConsumer = System.out::println;
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


}
