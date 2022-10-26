import java.io.*;
import java.util.*;

public class Richest {
    public static void main(String[] args) throws IOException{

        int[] data = FillArray(args[0]); // fill the Array with the data from the text file
        
    }

    private static int[] FillArray(String fileString) throws FileNotFoundException {
        File file = new File(fileString); // convert the command line argument string to a file
        Scanner countScanner = new Scanner(file); // initalize a file reader
        int count = 0;
        while (countScanner.hasNextLine()) { // count the number of lines in the file
            countScanner.nextLine();
            count++;    
        }
        countScanner.close(); // close the file
        Scanner fileScanner = new Scanner(file); // initalize a file reader
        int[] data = new int[count]; // initalize of size count
        count = 0; // reset count

        while (fileScanner.hasNextLine()) { // iterate through the file and add all the contents into an array
            int currentLine = Integer.valueOf(fileScanner.nextLine());
            data[count] = currentLine;
            count++;
        }
        fileScanner.close(); // close the file
        return data;
    }
}
