package atv1;

public class ThreadCounter extends Thread {
  private int id;

  public ThreadCounter(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    System.out.println(id + ";" + Counter.getValue() + ";");
    Counter.increment();
  }
}
