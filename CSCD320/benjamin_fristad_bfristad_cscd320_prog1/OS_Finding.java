import java.io.*;
import java.util.*;

public class OS_Finding{
    public static void main(String[] args) throws IOException{

        int[] data = FillArray(args[0]); // fill the Array with the data from the text file
        int i = Integer.valueOf(args[1]);

        if(i > data.length || i <= 0) { // print null and exit the program if i is out of the bounds of the array
            System.out.println("null"); 
            return;
        }

        int number = Select(data, 0, data.length - 1, i);
        System.out.println(number);
    }

    private static int Select(int[] data, int p, int r, int i) {

        if(p == r) {
            return data[p];
        }

        int q = Partition(data, p, r); // A[q] os the pivot after partition
        int k = q - p + 1;

        if(i == k) {
            return data[q];
        }
        else if(i < k){
            return Select(data, p, q - 1, i);
        }
        else {
            return Select(data, q + 1, r, i - k);
        }
    }

    private static int Partition(int[] data, int left, int right) {

        int pivotIndex = (int) (Math.random() * (right - left)) + left; // holds the index of the pivot point
        int pivot = data[pivotIndex]; // assign the pivot point to the upper bound of the array
        int index = left; // assign the index to the lower bound of the array
        int temp;

        temp = pivot;
        data[pivotIndex] = data[right]; // swap the pivot point with the rightmost index
        data[right] = temp;

        // iterate through the array and move all values less than pivot point to the left and all values greater than the pivot point to the right
        for(int i = left; i < right; i++) {  
            if(data[i] <= pivot) {
                temp = data[i];
                data[i] = data[index];
                data[index] = temp;
                index++;
            } 
        }
        temp = data[index]; // swap the pivot point with element that the index variable points to
        data[index] = data[right];
        data[right] = temp;

        return index;
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