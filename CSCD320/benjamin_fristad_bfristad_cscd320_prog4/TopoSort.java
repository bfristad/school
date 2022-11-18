import java.io.*;
import java.util.*;

public class TopoSort {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList[] graph = buildGraph(args[0]);
        DepthFirstSearch(graph);
    }

    private static void DepthFirstSearch(LinkedList[] graph) {
        LinkedList.Node node;
        boolean[] isVisited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(!isVisited[i]) {
                System.out.print(i + ", ");
                isVisited[i] = true;
                if(graph[i].head != null){
                    node = graph[i].head;
                    DepthFirstSearchHelper(graph, node, isVisited);
                }
            }  
        }
    }

    private static void DepthFirstSearchHelper(LinkedList[] graph, LinkedList.Node node, boolean[] isVisited) {
        while(node != null) {
            if(!isVisited[node.data]){
                System.out.print(node.data + ", ");
            }
            isVisited[node.data] = true;
            if(graph[node.data].head != null && !isVisited[graph[node.data].head.data]) {
                DepthFirstSearchHelper(graph, graph[node.data].head, isVisited);
            }
            node = node.next;
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
}