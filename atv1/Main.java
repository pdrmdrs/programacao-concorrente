package atv1;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static ArrayList<ThreadCounter> threads = new ArrayList<ThreadCounter>();

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of threads to be created:");

    int numberOfThreads = scanner.nextInt();
    scanner.close();

    for (int i = 0; i < numberOfThreads; i++) {
      threads.add(new ThreadCounter(i));
    }

    int threadIndex = 0;
    while (true) {
      ThreadCounter thread = threads.get(threadIndex);
      if (thread.getState() != State.TERMINATED) {
        thread.start();
      } else {
        thread.run();
      }
      thread.join();
      if (threadIndex < threads.size() - 1) {
        threadIndex++;
      } else {
        threadIndex = 0;
      }
    }
  }
}
