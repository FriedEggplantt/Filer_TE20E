import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Files {

    public Files(){
        System.out.println("Enter a file name: ");
        Scanner name = new Scanner(System.in);
        String fileName = name.next();

        File f = new File(fileName);
        try {
            if(f.createNewFile()){
                System.out.println("file already created");
            }else{
                System.out.println("file exists");
            }
        }catch(IOException e){
            System.out.println("ERROR");
            e.printStackTrace();
        }
        System.out.println("File name: " + f.getName());
        System.out.println("File position: " + f.getPath());
    }

}
