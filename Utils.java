import java.io.*;

public class Utils {
    public static String readDataFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeToFile(String content, String path) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path))) {
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void continueWriteToFile(String content, String path) {
        try (FileWriter out = new FileWriter(path, true)) {
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFile(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) return file;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        File file = findFile("D:\\Github\\InputOutput", "input.txt");
        String data = readDataFromFile(file.getAbsolutePath());
        System.out.println("Data in file: " + data);

        if (file != null) {
            System.out.println(file.getAbsolutePath());
            String content = readDataFromFile(file.getAbsolutePath());
            File outputFile = new File("D:\\Github\\InputOutput\\output.txt");
            writeToFile(content, outputFile.getAbsolutePath());
            writeToFile("Hello everyone\n", outputFile.getAbsolutePath());
            continueWriteToFile("My name is Hung\n", outputFile.getAbsolutePath());
        }
    }
}
