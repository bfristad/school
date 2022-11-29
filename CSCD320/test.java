import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class test {

    static class Edge {

        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {

            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class HeapNode {

        int vertex;
        int distance;
    }
    static class Graph {

        int vertices;
        static LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public static Graph buildGraph(String fileString) throws FileNotFoundException {
        
            File file = new File(fileString); // convert the command line argument string to a file
            Scanner countScanner = new Scanner(file); // initalize a file reader
            int count = 0;
            while (countScanner.hasNextLine()) { // count the number of lines in the file
                countScanner.nextLine();
                count++;    
            }
            countScanner.close(); // close the file
            Scanner fileScanner = new Scanner(file); // initalize a file reader
            Graph graph = new Graph(count);
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
                        Graph.addEdge(nodeValue, destination, weight);
                    }
                }
                count++;
            }
            fileScanner.close(); // close the file
            return graph;
        }

        public static void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
        }

        public void dijkstra_GetMinDistances(int sourceVertex) {

            int INFINITY = Integer.MAX_VALUE;
            boolean[] SPT = new boolean[vertices];

            //create a empty set
            Set<HeapNode> shortestPath = new HashSet<>();

            //create heapNode for all the vertices
            HeapNode [] heapNodes = new HeapNode[vertices];
            for (int i = 0; i <vertices ; i++) {
                heapNodes[i] = new HeapNode();
                heapNodes[i].vertex = i;
                heapNodes[i].distance = INFINITY;
            }

            //decrease the distance for the first index
            heapNodes[sourceVertex].distance = 0;

            //add all the vertices to the MinHeap
            MinHeap minHeap = new MinHeap(vertices);

            for (int i = 0; i <vertices ; i++) {
                minHeap.insert(heapNodes[i]);
            }
            //while minHeap is not empty
            while(!minHeap.isEmpty()){
                //extract the min
                HeapNode extractedNode = minHeap.extractMin();
                shortestPath.add(extractedNode);
                //extracted vertex
                int extractedVertex = extractedNode.vertex;
                SPT[extractedVertex] = true;

                //iterate through all the adjacent vertices
                LinkedList<Edge> list = adjacencylist[extractedVertex];
                for (int i = 0; i <list.size() ; i++) {
                    Edge edge = list.get(i);
                    int destination = edge.destination;
                    //only if destination vertex is not present in SPT
                    if(SPT[destination]==false) {
                        ///check if distance needs an update or not
                        //means check total weight from source to vertex_V is less than
                        //the current distance value, if yes then update the distance
                        int newKey = heapNodes[extractedVertex].distance + edge.weight ;
                        int currentKey = heapNodes[destination].distance;
                        if(currentKey>newKey){
                            decreaseKey(minHeap, newKey, destination);
                            heapNodes[destination].distance = newKey;
                        }
                    }
                }
    }

    //print SPT
    printDijkstra(heapNodes, sourceVertex, shortestPath);
    }

    public void decreaseKey(MinHeap minHeap, int newKey, int vertex) {

        //get the index which distance's needs a decrease;
        int index = minHeap.indexes[vertex];

        //get the node and update its value
        HeapNode node = minHeap.mH[index];
        node.distance = newKey;
        minHeap.bubbleUp(index);
    }

    public void printDijkstra(HeapNode[] resultSet, int sourceVertex, Set<HeapNode> shortestPath) {
        for (int i = 0; i <vertices ; i++) {
            if(sourceVertex != i && resultSet[i].distance != Integer.MAX_VALUE) {
                System.out.println("[" + i + "] shortest path: (" + sourceVertex + "," + i + ") shortest distance: " + resultSet[i].distance);
            }
            else if(resultSet[i].distance == Integer.MAX_VALUE) {
                System.out.println("[" + i + "] unreachable");
            }
        }
    }
    }
    static class MinHeap {
        int capacity;
        int currentSize;
        HeapNode[] mH;
        int [] indexes; //will be used to decrease the distance

        public MinHeap(int capacity) {
            this.capacity = capacity;
            mH = new HeapNode[capacity + 1];
            indexes = new int[capacity];
            mH[0] = new HeapNode();
            mH[0].distance = Integer.MIN_VALUE;
            mH[0].vertex=-1;
            currentSize = 0;
        }

        public void display() {
            for (int i = 0; i <=currentSize; i++) {
                System.out.println(" " + mH[i].vertex + " distance " + mH[i].distance);
            }
        }

        public void insert(HeapNode x) {
            currentSize++;
            int idx = currentSize;
            mH[idx] = x;
            indexes[x.vertex] = idx;
            bubbleUp(idx);
        }

        public void bubbleUp(int pos) {
            int parentIdx = pos/2;
            int currentIdx = pos;
            while (currentIdx > 0 && mH[parentIdx].distance > mH[currentIdx].distance) {
                HeapNode currentNode = mH[currentIdx];
                HeapNode parentNode = mH[parentIdx];

                //swap the positions
                indexes[currentNode.vertex] = parentIdx;
                indexes[parentNode.vertex] = currentIdx;
                swap(currentIdx,parentIdx);
                currentIdx = parentIdx;
                parentIdx = parentIdx/2;
            }
        }

        public HeapNode extractMin() {
            HeapNode min = mH[1];
            HeapNode lastNode = mH[currentSize];
            // update the indexes[] and move the last node to the top
            indexes[lastNode.vertex] = 1;
            mH[1] = lastNode;
            mH[currentSize] = null;
            sinkDown(1);
            currentSize--;
            return min;
        }

        public void sinkDown(int k) {
            int smallest = k;
            int leftChildIdx = 2 * k;
            int rightChildIdx = 2 * k+1;
            if (leftChildIdx < heapSize() && mH[smallest].distance > mH[leftChildIdx].distance) {
                smallest = leftChildIdx;
            }
            if (rightChildIdx < heapSize() && mH[smallest].distance > mH[rightChildIdx].distance) {
                smallest = rightChildIdx;
            }
            if (smallest != k) {

                HeapNode smallestNode = mH[smallest];
                HeapNode kNode = mH[k];

                //swap the positions
                indexes[smallestNode.vertex] = k;
                indexes[kNode.vertex] = smallest;
                swap(k, smallest);
                sinkDown(smallest);
            }
        }

        public void swap(int a, int b) {
            HeapNode temp = mH[a];
            mH[a] = mH[b];
            mH[b] = temp;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public int heapSize(){
            return currentSize;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {

        Graph graph = Graph.buildGraph("benjamin_fristad_bfristad_cscd320_prog5/data.txt");
        int sourceVertex = 0;
        graph.dijkstra_GetMinDistances(sourceVertex);
    }

}
