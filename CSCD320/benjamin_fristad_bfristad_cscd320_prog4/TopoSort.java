import java.io.*;
import java.util.*;

public class TopoSort {

    public static int time;
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList[] graph = buildGraph("benjamin_fristad_bfristad_cscd320_prog4/data.txt");
        printGraph(graph);
        DepthFirstSearch(graph);
    }

    private static void DepthFirstSearch(LinkedList[] graph) {
        System.out.println("0");

        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(graph[i].size != 0 && visited[i] == false) {
                DepthFirstSearchHelper(graph, graph[i].head, visited);
                visited[i] = true;
            }
        }
    }

    private static void DepthFirstSearchHelper(LinkedList[] graph, LinkedList.Node node, boolean[] visited) {
        time ++;
        visited[node.data] = true;
        node.d = time;
        System.out.println(node.data);
        int i = 0;
        while(i < graph[node.data].size) {
            if(!visited[node.data]) {
                DepthFirstSearchHelper(graph, graph[node.data].head, visited);
                
            }
            node.f = time;
            node = node.next;
            i++;
        }
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
            if(parts.length == 2) { // add all point values to the linked list if they exist
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
        for(int i = 0; i < graph.length; i++) {
            System.out.print("Node: " + i + " Links [ ");
            LinkedList.printList(graph[i]);
            System.out.print("]\n");
        }
    }

}

class LinkedList {
 
    Node head; // head of list
    int size = 0; // size of list
 
    // Linked list Node.
    // Node is a static nested class
    // so main() can access it
    static class Node {
 
        int data;
        String color = "WHITE";
        int nodeTime = 0; 
        int p;
        int f;
        int d;
        Node next;
 
        // Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    // Method to insert a new node
    public static LinkedList insert(LinkedList list,
                                    int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;
 
        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
 
            // Insert the new_node at last node
            last.next = new_node;
        }
 
        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
 
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
 
            // Go to next node
            currNode = currNode.next;
        }
 
    }
}