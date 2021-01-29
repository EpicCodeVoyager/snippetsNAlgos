package core.dssolutions.btree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BTree {
  static Node root;

  static class Node {
    Integer data;
    Integer horizontalIndex = Integer.MAX_VALUE;
    Node left = null;
    Node right = null;

    public Node(Integer data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
  }

  public static void main(String[] args) {
    BTree tree = new BTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.root.left.right.right = new Node(8);
    tree.root.right.left = new Node(6);
    tree.root.right.right = new Node(7);
    System.out.println(tree.root);
    System.out.println("PreOrder:");
    traverseTreeDfsPreOrder(tree.root);
    System.out.println("\nInOrder:");
    traverseTreeDfsInOrder(tree.root);
    System.out.println("\nPostOrder:");
    traverseTreeDfsPostOrder(tree.root);
    System.out.println("\nBFS:");
    traverseTreeBfs(tree.root);
    System.out.println("\nBottom view:");
    bottomViewTree(tree.root);
    System.out.println("\nRight view:");
    rightViewTree(tree.root, 1);

    MaxLevel.maxLevel = 0;
    System.out.println("\nLeft view:");
    leftViewTree(tree.root, 1);
    System.out.println("\nTop view:");
    treeTopView(tree.root);
    System.out.println("\n Height Details: " + height(tree.root));
  }

  public static void treeTopView(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    int hd = 0;
    root.horizontalIndex = hd;
    Map<Integer, Integer> map = new TreeMap<>();

    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      hd = tempNode.horizontalIndex;

      if (!map.containsKey(hd)) map.put(hd, tempNode.data);

      if (tempNode.left != null) {
        tempNode.left.horizontalIndex = hd - 1;
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        tempNode.right.horizontalIndex = hd + 1;
        queue.add(tempNode.right);
      }
    }
    System.out.println(map.toString());
  }

  public static class MaxLevel {
    public static int maxLevel = 0;
  }

  public static void rightViewTree(Node root, int level) {

    if (root == null) {
      return;
    }

    if (level > MaxLevel.maxLevel) {
      System.out.print(root.data + " ");
      MaxLevel.maxLevel = level;
    }

    rightViewTree(root.right, level + 1);
    rightViewTree(root.left, level + 1);
  }

  public static void leftViewTree(Node root, int level) {

    if (root == null) {
      return;
    }

    if (level > MaxLevel.maxLevel) {
      System.out.println(root.data);
      MaxLevel.maxLevel = level;
    }

    leftViewTree(root.left, level + 1);
    leftViewTree(root.right, level + 1);
  }

  public static void bottomViewTree(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    Map<Integer, Integer> map = new TreeMap<>();
    int horizontalIndex = 0;
    root.horizontalIndex = horizontalIndex;

    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      horizontalIndex = tempNode.horizontalIndex;
      map.put(horizontalIndex, tempNode.data);

      if (tempNode.left != null) {
        tempNode.left.horizontalIndex = horizontalIndex - 1;
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        tempNode.right.horizontalIndex = horizontalIndex + 1;
        queue.add(tempNode.right);
      }
    }
    System.out.println(map.toString());
  }

  public static void traverseTreeBfs(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(" " + tempNode.data);
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int lHeight = height(root.left);
    int rHeight = height(root.right);
    return 1 + Math.max(lHeight, rHeight);
  }

  public static void traverseTreeDfsPreOrder(Node root) {
    System.out.print(root.data);
    if (root.left != null) traverseTreeDfsPreOrder(root.left);
    if (root.right != null) traverseTreeDfsPreOrder(root.right);
  }

  public static void traverseTreeDfsInOrder(Node root) {
    if (root.left != null) traverseTreeDfsInOrder(root.left);
    System.out.print(root.data);
    if (root.right != null) traverseTreeDfsInOrder(root.right);
  }

  public static void traverseTreeDfsPostOrder(Node root) {
    if (root.left != null) traverseTreeDfsPostOrder(root.left);
    if (root.right != null) traverseTreeDfsPostOrder(root.right);
    System.out.print(root.data);
  }
}
