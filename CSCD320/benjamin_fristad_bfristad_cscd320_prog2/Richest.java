import java.io.*;
import java.util.*;

public class Richest {
    public static void main(String[] args) throws IOException{

        int arraySize = 16;
        int[] data = FillArray(args[0], arraySize); // fill the Array with the data from the text file
        int heapSize = data[0];

        BuildMinHeap(data, heapSize);

        if(heapSize == arraySize){
            MaxValueList(data, args[0], heapSize);
        }
        
        HeapSort(data, heapSize);
        Write(data, heapSize);
    }

    /*
     * This function will iterate through a file and fill an array with the largest values from that file
     */

    private static void MaxValueList(int[] data, String fileString, int heapSize) throws FileNotFoundException {
        File file = new File(fileString); // convert the command line argument string to a file
        Scanner fileScanner = new Scanner(file); // initalize a file reader
        
        for (int i = 1; i < data.length; i++) {
            fileScanner.nextLine();
        }

        while(fileScanner.hasNextLine()){ // iterate through the file and check if the key of root of the tree is less than the value at the current line
            int currentLine = Integer.valueOf(fileScanner.nextLine());

            if(currentLine > data[1]) {
                data[1] = currentLine;
                MinHeapify(data, 1, heapSize);
            }
        }
        fileScanner.close(); // close the file
    }

    private static void HeapSort(int[] data, int heapSize) {
        int temp;
        BuildMinHeap(data, heapSize);
        
        for(int i = heapSize - 1; i >= 2; i--){
            temp = data[i];
            data[i] = data[1];
            data[1] = temp;
            heapSize--;
            MinHeapify(data, 1, heapSize);
        }
    } 

    private static void BuildMinHeap(int[] data, int heapSize) {

        for(int i = (heapSize / 2); i >= 1; i-- ){
            MinHeapify(data, i, heapSize);
        }
    }

    private static void MinHeapify(int[] data, int i, int heapSize) {

        int left = (2 * i); // index of the left child
        int right = (2 * i) + 1; // index of right child
        int smallest;
        int temp;

        if(left < heapSize && data[left] < data[i]) { // check if left is smallest
            smallest = left;
        }
        else {
            smallest = i;
        }
        if(right < heapSize && data[right] < data[smallest]) { // check if right is the smallest
            smallest = right;
        }
        if(smallest != i) { // if the smallest key isn't at location i change the key at index i to be the smallest value of the three and recursivly check the next level on the tree
            temp = data[i];
            data[i] = data[smallest];
            data[smallest] = temp;
            MinHeapify(data, smallest, heapSize);
        }
    }

    private static int[] FillArray(String fileString, int arraySize) throws FileNotFoundException {
        File file = new File(fileString); // convert the command line argument string to a file
        
        Scanner fileScanner = new Scanner(file); // initalize a file reader
        int[] data = new int[arraySize]; // initalize the array of size arraySize
        
        //for(int i = 1; i < data.length; i++){ // iterate through the file and fill the array
        int i = 1;
        while(i < data.length && fileScanner.hasNextLine()) {
            int currentLine = Integer.valueOf(fileScanner.nextLine());
            data[i] = currentLine;
            i++;
        }
        fileScanner.close(); // close the file
        data[0] = i; // store the size of the heap in index[0]
        return data;
    }

    public static void Write (int[] data, int heapSize) throws IOException{
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter("richest.output"));
        for (int i = 1; i < heapSize; i++) {
          
          outputWriter.write(Integer.toString(data[i]));
          outputWriter.newLine();
        }
        outputWriter.flush();  
        outputWriter.close();  
      }
}


