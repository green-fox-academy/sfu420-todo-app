import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileOPs {
  protected List<String> lines = new ArrayList<>();
  protected final String filename = "tasks.txt";

  public List<String> readFile() {
    try {
      Path filePath = Paths.get("./" + this.filename);
      this.lines = Files.readAllLines(filePath);
    } catch (IOException e) {
      System.out.println("The file does not exist, trying to create a new one...");
      writeFile(this.lines);
//      System.exit(2);
    }
    return this.lines;
  }

  public void writeFile(List<String> content) {
    try {
      Path filePath = Paths.get("./" + this.filename);
      Files.write(filePath, content);
    } catch (IOException e) {
      System.out.println("Can't write file. Please check permission");
      System.exit(2);
    }
  }

  public void printContent(List<String> content) {
    for (String line : content) {
      System.out.println(line);
    }
  }

  public void fillFile() {
    this.lines.add((this.lines.size() + 1) + " - " + "Walk the dog");
    this.lines.add((this.lines.size() + 1) + " - " + "Bux Milk");
    this.lines.add((this.lines.size() + 1) + " - " + "Do homework");
    writeFile(this.lines);
  }

  public void addNewTask(String newTask) {
    this.lines.add((this.lines.size() + 1) + " - " + newTask);
    writeFile(this.lines);
  }

  public void removeTask(String index) {
    boolean exists = false;
    for (int i = 0; i < this.lines.size(); i++) {
      String[] temp = this.lines.get(i).split(" ");
      if (Integer.parseInt(temp[0]) == Integer.parseInt(index)) {
        this.lines.remove(i);
        exists = true;
      }
    }
    if (exists) {
      writeFile(this.lines);
    } else {
      System.out.println("Given task does not exist!");
    }
  }
}
