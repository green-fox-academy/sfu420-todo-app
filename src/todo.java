public class todo {

  public static void main(String[] args) {
    FileOPs fIO = new FileOPs();

    fIO.fillFile();

    if (args.length == 0) {
      printHelp();
    } else if (args[0].equals("-l")) {
      fIO.printContent(fIO.readFile());
    }

  }

  public static void printHelp() {
    String help = "\nCommand Line Todo application\n" +
        "=============================\n\n" +
        "Command line arguments:\n" +
        "\t-l   Lists all the tasks\n" +
        "\t-a   Adds a new task\n" +
        "\t-r   Removes a task\n" +
        "\t-c   Completes a task";
    System.out.println(help);
  }


}