class Main {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    String[] vertices = {
        "Liberal Arts",
        "Student Services",
        "Health Careers & Sciences",
        "Health Technologies Center",
        "Recreation Center",
        "Technology Learning Center",
        "Business & Technology",
        "Theatre"
    };
    // 2-Define Edges
int[][] edges = {
    {0, 1}, // Liberal Arts ↔ Student Services
    {1, 2}, // Student Services ↔ Health Careers & Sciences
    {2, 3}, // Health Careers & Sciences ↔ Health Technologies Center
    {1, 5}, // Student Services ↔ Technology Learning Center
    {5, 6}, // Technology Learning Center ↔ Business & Technology
    {5, 4}, // Technology Learning Center ↔ Recreation Center

    {6, 7}, // Business & Technology ↔ Theatre
    {1, 7}  // Student Services ↔ Theatre (есть проход через центр)
};
    // 3. Create the graph (name "graph") using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);
    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business & Technology" building
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);
    // 5. Retrieve and print the search order of the DFS traversal
    System.out.println("DFS search order:");
    java.util.List<Integer> order = dfs.getSearchOrder();
    for (int i = 0; i < order.size(); i++) {
        int v = order.get(i);
        System.out.println(v + ": " + vertices[v]);
    }
    // 6. Print the parent-child relationships for each vertex during the DFS traversal
    System.out.println("\nParent-child relationships:");
    for (int i = 0; i < vertices.length; i++) {
        int p = dfs.getParent(i);
        if (p != -1) {
            System.out.println(vertices[p] + " -> " + vertices[i]);
        }
    }
    // 7. Call the printPath method (assuming this method exists in the UnweightedGraph class)
    System.out.println();
    dfs.printPath(3); // Health Technologies Center
    System.out.println();
    dfs.printPath(1); // Student Services
    System.out.println();
    dfs.printPath(4); // Recreation Center
    System.out.println();
    // 8. Call printTree() to print the entire DFS tree (assuming this method exists in the UnweightedGraph class)
    System.out.println("\nDFS Tree:");
    dfs.printTree();
  }
}