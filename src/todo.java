import java.util.Arrays;

public class Todo {

  public static void main(String[] args) {
    FileOPs fIO = new FileOPs();

    String[] arguments = {"-l", "-a", "-r", "-c"};

    fIO.readFile();
    //fIO.fillFile();

    if (args.length == 0) {
      printHelp();
    } else if (Arrays.asList(arguments).contains(args[0])) {
      if (args[0].equals("-l")) {
        if (fIO.getTasks().size() == 0) {
          System.out.println("No todos for today! :)");
        } else {
          fIO.printContent();
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
    } else {
      System.out.println("Unsupported argument");
      System.exit(2);
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