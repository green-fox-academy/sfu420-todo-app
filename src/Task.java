public class Task {
  protected boolean isDone;
  protected String name;

  public Task(String name) {
    this.isDone = false;
    this.name = name;
  }

  public Task(boolean isDone, String name) {
    this.isDone = isDone;
    this.name = name;
  }
}
