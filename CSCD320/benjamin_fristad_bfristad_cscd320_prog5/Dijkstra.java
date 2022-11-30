import java.io.*;
import java.util.*;


public class Dijkstra {

    public static void main(String[] args) throws FileNotFoundException {
        
        LinkedList[] graph = buildGraph(args[0]);
        int startVertex = Integer.parseInt(args[1]);
        
        dijkstra(graph, startVertex);
    }

    public static void addEdge(LinkedList[] graph, int source, int destination, int weight) {
        graph[source].add(graph[source], source, destination, weight);
        graph[source].size++;
    }

    public static void dijkstra(LinkedList[] graph, int start) {

        boolean[] visited = new boolean[graph.length];
        HeapNode [] heapNodes = new HeapNode[graph.length];
        String[] shortestPath = new String[graph.length];
        Arrays.fill(shortestPath, "");

        for (int i = 0; i < graph.length ; i++) {

            heapNodes[i] = new HeapNode();
            heapNodes[i].vertex = i;
            heapNodes[i].distance = Integer.MAX_VALUE;
        }
    
        heapNodes[start].distance = 0;
        MinHeap minHeap = new MinHeap(graph.length);
    
        for (int i = 0; i < graph.length ; i++) {
            minHeap.insert(heapNodes[i]);
        }
        
        while(minHeap.maxSize != 0) {
            
            HeapNode extractedNode = minHeap.extractMin();
            
            visited[extractedNode.vertex] = true;
            LinkedList list = graph[extractedNode.vertex];
            for (int i = 0; i < list.size ; i++) {
                LinkedList.Node edge = list.get(list, i);
                int destination = edge.destination;
                if(!visited[destination]) {
                    int newKey = heapNodes[extractedNode.vertex].distance + edge.weight ;
                    int currentKey = heapNodes[destination].distance;
                    if(currentKey > newKey){
                        int index = minHeap.indexes[destination];
                        HeapNode node = minHeap.minHeap[index];
                        node.distance = newKey;
                        minHeap.repairMinHeap(index);

                        heapNodes[destination].distance = newKey;
                        heapNodes[destination].p = extractedNode;
                    }
                }
            }

            // traverse the p values and prepend them to a string for output
            HeapNode current = heapNodes[extractedNode.vertex];

            while(current.p != null) {
                shortestPath[extractedNode.vertex] = current.p.vertex + ", " + shortestPath[extractedNode.vertex];
                current = current.p;
            }
            // append last vertex since it wont have a p value
            shortestPath[extractedNode.vertex] += extractedNode.vertex;
        }
        
        // print results
        for (int i = 0; i < graph.length ; i++) {
            if(start != i && heapNodes[i].distance != Integer.MAX_VALUE && heapNodes[i].distance >= 0) {
                System.out.println("[" + i + "] shortest path: (" + shortestPath[i] + ") shortest distance: " + heapNodes[i].distance);
            }
            else if(start != i &&  ( heapNodes[i].distance == Integer.MAX_VALUE || heapNodes[i].distance <= 0 )) {
                System.out.println("[" + i + "] unreachable");
            }
        }
    }

    public static LinkedList[] buildGraph(String fileString) throws FileNotFoundException {
    
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
        
        for (int i = 0; i < count ; i++) {
            graph[i] = new LinkedList();
        }

        count = 0; // reset count

        while (fileScanner.hasNextLine()) { // iterate through the file and add all the contents into an array
            String currentLine = fileScanner.nextLine().replaceAll("\\s", ""); // read the line and remove all whitespace
            String parts[] = currentLine.split(":"); // split the input data on the colon
            int nodeValue = Integer.parseInt(parts[0]); // store the first value of the split into nodeValue
            if(parts.length == 2) { // add all point values to the linked list if they exist
                String destinations[] = parts[1].split(";");
            
                for(int i = 0; i < destinations.length; i++) {
                    String splitDestinations[] = destinations[i].split(",");
                    int destination = Integer.parseInt(splitDestinations[0]);
                    int weight = Integer.parseInt(splitDestinations[1]);
                    addEdge(graph, nodeValue, destination, weight);
                }
            }
            count++;
        }
        fileScanner.close(); // close the file
        return graph;
    }

    static class LinkedList {

        int start;
        int destination;
        int weight;
        Node head = null;
        int size = 0;
    
        class Node {
            int start;
            int destination;
            int weight;
            Node next;
    
            public Node(int source, int destination, int weight) {
    
                this.start = source;
                this.destination = destination;
                this.weight = weight;
                this.next = null;
            }
    
        }
    
        public void add(LinkedList list, int source, int destination, int weight) {
            Node newNode = new Node(source, destination, weight);
            if (list.head == null) {
                list.head = newNode;
            } else {
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        }
    
        public Node get(LinkedList list, int index) {
            if (list == null) {
                return null;
            }
            LinkedList.Node current = list.head;
            int i = 0;
            while (list.size > i) {
                if (i == index) {
                    return current;
                }
                current = current.next;
                i++;
            }
            return null;
        }
    }
    
    static class HeapNode {

        int vertex;
        int distance;
        HeapNode p; 
    } 

    static class MinHeap {

        int size;
        int maxSize;
        HeapNode[] minHeap;
        int [] indexes;

        public MinHeap(int size) {
            this.size = size;
            minHeap = new HeapNode[size + 1];
            indexes = new int[size];
            minHeap[0] = new HeapNode();
            minHeap[0].distance = Integer.MIN_VALUE;
            minHeap[0].vertex=-1;
            maxSize = 0;
        }

        public void insert(HeapNode newNode) {
            maxSize++;
            int index = maxSize;
            minHeap[index] = newNode;
            indexes[newNode.vertex] = index;
            repairMinHeap(index);
        }

        public void repairMinHeap(int node) {
            int parentIndex = node/2;
            int currentIndex = node;
            while (currentIndex > 0 && minHeap[parentIndex].distance > minHeap[currentIndex].distance) {

                HeapNode currentNode = minHeap[currentIndex];
                HeapNode parentNode = minHeap[parentIndex];

                indexes[currentNode.vertex] = parentIndex;
                indexes[parentNode.vertex] = currentIndex;

                HeapNode temp = minHeap[currentIndex];
                minHeap[currentIndex] = minHeap[parentIndex];
                minHeap[parentIndex] = temp;

                currentIndex = parentIndex;
                parentIndex = parentIndex/2;
            }
        }

        public HeapNode extractMin() {
            HeapNode min = minHeap[1];
            HeapNode lastNode = minHeap[maxSize];
    
            indexes[lastNode.vertex] = 1;
            minHeap[1] = lastNode;
            minHeap[maxSize] = null;
            minHeapify(1);
            maxSize--;
            return min;
        }

        public void minHeapify(int i) {
            int smallest = i;
            int left = 2 * i;
            int right = 2 * i+1;
            if (left < maxSize && minHeap[smallest].distance > minHeap[left].distance) {
                smallest = left;
            }
            if (right < maxSize && minHeap[smallest].distance > minHeap[right].distance) {
                smallest = right;
            }
            if (smallest != i) {

                HeapNode smallestNode = minHeap[smallest];
                HeapNode kNode = minHeap[i];

                indexes[smallestNode.vertex] = i;
                indexes[kNode.vertex] = smallest;

                HeapNode temp = minHeap[i];
                minHeap[i] = minHeap[smallest];
                minHeap[smallest] = temp;

                minHeapify(smallest);
            }
        }
    }
}
