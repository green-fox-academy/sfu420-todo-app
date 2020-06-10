public class todo {

  public static void main(String[] args) {

    if (args.length == 0) {
      printHelp();
    }
  }

  public static void printHelp() {
    String help = "\nCommand Line Todo application\n" +
        "=============================\n\n" +
        "Command line arguments:\n" +
        "\t-l   Lists all the tasks\n" +
        "\t-a   Adds a new task\n" +
        "\t-r   Removes an task\n" +
        "\t-c   Completes an task";
    System.out.println(help);
  }
}