import java.io.*;
import java.util.*;

public class Dijkstra {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList[] graph = buildGraph("benjamin_fristad_bfristad_cscd320_prog5/data.txt");
        printGraph(graph);
    }

    private static LinkedList[] buildGraph(String fileString) throws FileNotFoundException {
        
        File file = new File(fileString); // convert the command line argument string to a file
        Scanner countScanner = new Scanner(file); // initalize a file reader
        int count = 0;
        while (countScanner.hasNextLine()) { // count the number of lines in the file
            countScanner.nextLine();
            count++;    
        }
        countScanner.close(); // close the file
        Scanner fileScanner = new Scanner(file); // initalize a file reader
        LinkedList[] graph = new LinkedList[count];
        count = 0; // reset count

        while (fileScanner.hasNextLine()) { // iterate through the file and add all the contents into an array
            String currentLine = fileScanner.nextLine().replaceAll("\\s", ""); // read the line and remove all whitespace
            String parts[] = currentLine.split(":"); // split the input data on the colon
            int nodeValue = Integer.parseInt(parts[0]); // store the first value of the split into nodeValue
            graph[nodeValue] = new LinkedList(); // initalize a new linked list at the location of nodeValue
            if(nodeValue == 0) {
                String pointerValues[] = parts[1].split(";");
                for(int i = 0; i < pointerValues.length; i++) {
                    String weightsArray[] = pointerValues[i].split(",");
                    int neighbor = Integer.parseInt(weightsArray[0]);
                    int weight = Integer.parseInt(weightsArray[1]);
                    

                }
            }
            else { // add all point values to the linked list if they exist
                String pointerValues[] = parts[1].split(",");
                for(int i = 0; i < pointerValues.length; i++) {
                    int pointerValue = Integer.parseInt(pointerValues[i]);
                    LinkedList.insert(graph[nodeValue], pointerValue);
                    graph[nodeValue].size++;
                }
            }
            count++;
        }
        fileScanner.close(); // close the file
        return graph;
    }

    private static void printGraph(LinkedList[] graph) {

        for(int i = 0; i < graph.length; i++){
            LinkedList.printList(graph[i]);
        }
    }
}

class LinkedList {
 
    Node head;
    int size = 0; 
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
 
    public static LinkedList insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        new_node.next = null;
 
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
    
        System.out.print("LinkedList: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }
}