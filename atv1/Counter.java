package atv1;

public class Counter {
  private static int value = 0;

  public static void increment() {
    value++;
  }

  public static int getValue() {
    return value;
  }
}
