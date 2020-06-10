import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOPs {
  protected List<Task> tasks = new ArrayList<>();
  protected final String filename = "tasks.txt";

  public void readFile() {
    List<String> fileLines = new ArrayList<>();
    try {
      Path filePath = Paths.get("./" + this.filename);
      fileLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("The file does not exist, trying to create a new one...");
      writeFile();
    }
    convertFileToTask(fileLines);
  }

  public void writeFile() {
    try {
      Path filePath = Paths.get("./" + this.filename);
      Files.write(filePath, convertTaskToFile());
    } catch (IOException e) {
      System.out.println("Can't write file. Please check permission");
      System.exit(2);
    }
  }

  public void convertFileToTask(List<String> fileLines) {
    if (fileLines.size() > 0) {
      for (String line : fileLines) {
        String[] lineContent = line.split(",");
        this.tasks.add(new Task(lineContent[1], Boolean.parseBoolean(lineContent[0])));
      }
    }
  }

  public List<String> convertTaskToFile() {
    List<String> fileLines = new ArrayList<>();
    for (Task task : this.tasks) {
      fileLines.add(task.isDone + "," + task.name);
    }
    return fileLines;
  }

  public List<Task> getTasks() {
    return this.tasks;
  }

  public void printContent() {
    for (int i = 0; i < this.tasks.size(); i++) {
      System.out.println(
          (i + 1) + " - " + (this.tasks.get(i).isDone ? "[x] " : "[ ] ") + this.tasks.get(i).name);
    }
  }

  public void addNewTask(String name) {
    this.tasks.add(new Task(name));
    writeFile();
  }

  public void removeTask(String indexOfTask) {
    if (isNumber(indexOfTask)) {
      try {
        this.tasks.remove(Integer.parseInt(indexOfTask) - 1);
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Unable to remove: index is out of bound");
      }
    }
    writeFile();
  }

  public boolean isNumber(String indexOfTask) {
    try {
      Integer temp = Integer.parseInt(indexOfTask);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Unable to remove: index is not a number");
      System.exit(2);
    }
    return false;
  }

  public void fillFile() {
    this.tasks.add(new Task("Walk the dog"));
    this.tasks.add(new Task("Buy Milk", true));
    this.tasks.add(new Task("Do homework"));
    writeFile();
  }
}