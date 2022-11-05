import java.io.*;
import java.util.*;

public class FastMatrixMulti {
    public static void main(String[] args) throws IOException{

        String fileString = args[0];
        int[] data = FillArray(fileString); // fill the Array with the data from the text file
        matrixChangeOrder(data);
    } 

    private static void matrixChangeOrder(int[] p) {
        int n = p.length; // the number of matrices

        int[][] m = new int[n][n]; // initalize array for storing optimal time cost
        int[][] s = new int[n][n]; // initalize array for storing optimal parentheses location
        int j, q;

        for(int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        for(int h = 2; h < n; h++) { // h is the length of the subchain

            for(int i = 1; i < n - h + 1; i++) { // i is starting position of the sub-chain
                j = i + h - 1; // j is the ending position of the sub-chain
                m[i][j] = Integer.MAX_VALUE; // set m[i][j] to infinity
                
                for(int k = i; k <= j - 1; k++) { // try different positions for the outmost pair of parentheses for the current sub-chain 
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if(q < m[i][j]) {
                        m[i][j] = q; // store the optimal time cost
                        s[i][j] = k; // the position of the outmost parantheses for optimally
                    }
                }
            }
        }

        System.out.println(m[1][n - 1]);

        printOptimalParens(s, 1, n - 1);
    }

    private static void printOptimalParens(int[][] s, int i, int j){
        if(i == j) {
            System.out.print("A" + i);
        }
        else
        {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
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

