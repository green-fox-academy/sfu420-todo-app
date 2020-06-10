public class todo {

  public static void main(String[] args) {
    FileOPs fIO = new FileOPs();

    fIO.readFile();
//    fIO.fillFile();

    if (args.length == 0) {
      printHelp();
    } else if (args[0].equals("-l")) {
      if (fIO.readFile().size() == 0) {
        System.out.println("No todos for today! :)");
      } else {
        fIO.printContent(fIO.readFile());
      }
    } else if (args[0].equals("-a")) {
      if (args.length < 2) {
        System.out.println("Unable to add: no task provided");
      } else {
        fIO.addNewTask(args[1]);
      }
    } else if (args[0].equals("-r")) {
      if (args.length < 2) {
        System.out.println("Unable to remove: no index provided");
      } else {
        fIO.removeTask(args[1]);
      }
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