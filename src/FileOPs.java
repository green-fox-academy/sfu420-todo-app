import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileOPs {
  protected List<Task> lines = new ArrayList<>();
  protected final String filename = "tasks.txt";

  public List<String> readFile() {
    List<String> fileLines = new ArrayList<>();
    try {
      Path filePath = Paths.get("./" + this.filename);
      fileLines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("The file does not exist, trying to create a new one...");
      writeFile();
    }
    return fileLines;
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

  public List<Task> convertFileToTask() {
    List<String> fileLines;
    fileLines = readFile();
    if (fileLines.size() > 0) {
      for (String line : fileLines) {
        String[] lineContent = line.split(",");
        this.lines.add(new Task(Boolean.parseBoolean(lineContent[0]), lineContent[1]));
      }
    }
    return this.lines;
  }

  public List<String> convertTaskToFile() {
    List<String> fileLines = new ArrayList<>();
    for (Task line : this.lines) {
      fileLines.add(line.isDone + "," + line.name);
    }
    return fileLines;
  }

  public void printContent() {
    for (int i = 0; i < this.lines.size(); i++) {
      System.out.println(
          (i + 1) + " - " + (this.lines.get(i).isDone ? "[x] " : "[ ] ") + this.lines.get(i).name);
    }
  }

  public void addNewTask(String newTask) {
    this.lines.add(new Task(newTask));
    writeFile();
  }

  public void removeTask(String index) {
    if (isNumber(index)) {
      try {
        this.lines.remove(Integer.parseInt(index) - 1);
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Unable to remove: index is out of bound");
      }
    }
    writeFile();
  }

  public boolean isNumber(String index) {
    try {
      Integer temp = Integer.parseInt(index);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Unable to remove: index is not a number");
      System.exit(2);
    }
    return false;
  }

  public void fillFile() {
    this.lines.add(new Task("Walk the dog"));
    this.lines.add(new Task(true, "Buy Milk"));
    this.lines.add(new Task("Do homework"));
    writeFile();
  }
}