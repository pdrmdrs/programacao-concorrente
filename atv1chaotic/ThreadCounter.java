package atv1chaotic;

public class ThreadCounter extends Thread {
  private int id;

  private Counter counter;

  public ThreadCounter(int id, Counter counter) {
    this.id = id;
    this.counter = counter;
  }

  @Override
  public void run() {
    int counterValue = this.counter.getValue();
    System.out.println(id + ";" + counterValue + ";");
  }
}
