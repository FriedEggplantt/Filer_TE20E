import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Files {
    String fileName;
    Scanner input = new Scanner(System.in);

    public Files() {
        while (true) {
            System.out.println("Enter a file name: ");
            Scanner name = new Scanner(System.in);
            fileName = name.next();

            File f = new File(fileName);
            try {
                if (f.createNewFile()) {
                    System.out.println("file created");
                } else {
                    System.out.println("file already exists");
                }
            } catch (IOException e) {
                System.out.println("ERROR");
                e.printStackTrace();
            }
            System.out.println("File name: " + f.getName());
            System.out.println("File position: " + f.getPath());

            while (true) {
                System.out.println();
                System.out.println("You are currently manipulating file " + f.getName());
                System.out.println("What would you like to do?");
                System.out.println("1 - Write to the file");
                System.out.println("2 - Read from the file");
                System.out.println("3 - Create another file");
                System.out.println("4 - Chose another file");
                Scanner s = new Scanner(System.in);
                int choice = s.nextInt();
                if (choice == 1) {
                    writeToFile();
                } else if (choice == 2) {
                    readFromFile();
                } else if (choice == 3) {
                    break;
                }
                else if (choice == 4) {
                findFiles();
                }
                }
            }
        }

    public void writeToFile(){
        System.out.println("Would you like to add text or write over all text?");
        System.out.println("1 - Add text");
        System.out.println("2- Write over");
        Scanner choice = new Scanner(System.in);
        int chosing = choice.nextInt();
        if (chosing == 1){
            System.out.println("Write: ");
            String fileWrite = input.next();
            try {
                FileWriter myWriter = new FileWriter(fileName,true);
                myWriter.write(fileWrite);
                myWriter.close();

                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("Could not write to file");
                e.printStackTrace();
            }
        } else if (chosing == 2) {
            System.out.println("Write: ");
            String fileWrite = input.next();
            try {
                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write(fileWrite);
                myWriter.close();

                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("Could not write to file");
                e.printStackTrace();
            }
        }
    }
    public void readFromFile(){
        try {
            File myFile = new File(fileName);
            Scanner myScan = new Scanner(myFile);
            while(myScan.hasNextLine()) {
                System.out.println("This is the file's content:");
                String data = myScan.nextLine();
                System.out.println(data);
            }
            myScan.close();
        }catch(FileNotFoundException e){
            System.out.println("No such file");
            e.printStackTrace();
        }
    }
    public void findFiles(){
        File myFile= new File("C:\\Windows");
        String[] fileList= myFile.list();

        // loops through a list of strings and prints the content
        for(String aFileName: fileList){
            System.out.println(aFileName);
        }
    }

}
