import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileManagement {

    //Creates some variables that will be used in other methods and also creates the scanner that will take the user's input.
    public static String fileName;
    Scanner userInput = new Scanner(System.in);
    String deleteTitle;
    String lineToRemove;

    //Method that reads the contents of the disc file and prints it to the screen.
    public void readFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Method that copies the contents of the disc file onto a temp file whilst excluding the disc entry the user does not want. The old file is deleted
    and the temp file is renamed essentially removing the entry.*/
    public void removeDisc(String lineToRemove) {
        File filePath = new File(fileName);
        File tempFile = new File("temp.csv");


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            if(tempFile.renameTo(filePath)) {
                System.out.println("File renamed!");
            } else {
                System.out.println("File not renamed!");
            }
            if(filePath.delete()) {
                System.out.println("Record has been deleted!");
            } else {
                System.out.println("Record has not been deleted!");
            }
            tempFile.renameTo(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Method that asks the user which entry they want to delete and finds that entry in the disc file. This data is then passed
    onto the above method where it will be deleted*/
    public String userDeleteChoice() {
        File filePath = new File(fileName);

        System.out.println("Please enter the title of the disc you would like to delete: ");
        deleteTitle = userInput.nextLine();
        Scanner scanner;

        try {
            scanner = new Scanner(filePath).useDelimiter(",");

            while (scanner.hasNext()) {
                lineToRemove = scanner.nextLine();
                if (lineToRemove.contains(deleteTitle)) {
                    System.out.println(lineToRemove);
                    return lineToRemove;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Method that finds the specific entry the user is trying to find and prints it to screen. It does this using the disc's title.
    public void findDisc() {

        File filePath = new File(fileName);
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter the title of the disc you are looking for: ");
        String searchTerm = userInput.nextLine();
        Scanner scanner;

        try {
            scanner = new Scanner(filePath).useDelimiter(",");

            while (scanner.hasNext()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(searchTerm)) {
                    System.out.println(lineFromFile);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method that reads the contents of the disc file and then prints this to screen in reverse order making the latest entry come first and the oldest entry come last.
    public void readFileReverse() {
        try {
            File filePath = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            ArrayList list = new ArrayList();
            while (line != null) {
                line = reader.readLine();
                list.add(line);
            }
            reader.close();
            Collections.reverse(list);
            list.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*Method that asks the user what they want the disc file to be called. This information is then used to rename the file by
    creating a temp file with the new name which then can be used to rename the original file. This also writes the information
    needed for the program to recognise the new name on later launches of the application through the filename.txt which contains
    the name of the file.*/
    public void renameFile() {

        String newName;
        System.out.println("Please enter a new name for the file: ");
        newName = userInput.nextLine();
        File filePath = new File(fileName);
        File temp2 = new File(newName);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Filename.txt"));
            bw.write(newName);
            bw.close();
            if(filePath.renameTo(temp2)) {
                System.out.println("File renamed!");
                fileName = newName;
            } else {
                System.out.println("File not renamed!");
            }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        /*This method is used to find the filename of the disc file once the program has been started. It does this by searching
        the filename.txt file which contains the name of the disc file.*/
        public void findFileName() {
            try {
                BufferedReader br = new BufferedReader(new FileReader("Filename.txt"));
               this.fileName = br.readLine();
                br.close();
                File filePath = new File(this.fileName);
                System.out.println(this.fileName);
            } catch(IOException e) {

            }
        }

        public String getFileName() {
            return fileName;
        }
    }


