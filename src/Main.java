import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args)
    {
        Scanner inFile;
        JFileChooser chooser = new JFileChooser();

        String line = "";
        int lines = 0;
        int words = 0;
        int chars = 0;

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());

        try
        {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                System.out.println("File: " + target.getFileName());

                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    lines ++;

                    chars += line.length();
                    words += new StringTokenizer(line, " ,").countTokens();
                }

                inFile.close();
                System.out.printf("Line: %d\nWords: %d\nCharacters: %d\n", lines, words, chars);
            } else {
                System.out.println("You must select a file, rerun program to continue");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException Error");
            e.printStackTrace();
        }
    }
}