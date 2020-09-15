package atv1chaotic;

import java.util.Scanner;

public class Main {
  public static int counter = 0;

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of threads to be created:");
    int numberOfThreads = scanner.nextInt();
    System.out.println("The program should be chaotic or not?");
    boolean shouldBeChaotic = scanner.nextBoolean();
    scanner.close();
    if (shouldBeChaotic) {
      Counter counter = new Counter();
      for (int i = 0; i < numberOfThreads; i++) {
        int counterValue = counter.getValue();
        Thread thread = new ThreadCounter(i, counter);
        thread.start();
        counter.setValue(counterValue + 1);
      }
    } else {
      synchronized (Main.class) {
        Counter counter = new Counter();
        for (int i = 0; i < numberOfThreads; i++) {
          int counterValue = counter.getValue();
          Thread thread = new ThreadCounter(i, counter);
          thread.start();
          counter.setValue(counterValue + 1);
        }
      }
    }

  }
}
