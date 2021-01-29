package core.dssolutions;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

  public Node vertex;
  public LinkedList<Node>[] adjacency;

  public Graph(int vertexCount) {

    for (int i = 0; i < vertexCount; i++) {
      this.vertex.name = Integer.toString(i);
      this.adjacency[i] = new LinkedList<>();
    }
  }

  @Override
  public String toString() {
    return "Graph{" + "vertex=" + vertex + ", adjacency=" + Arrays.toString(adjacency) + '}';
  }

  public static void main(String[] args) {}
}
