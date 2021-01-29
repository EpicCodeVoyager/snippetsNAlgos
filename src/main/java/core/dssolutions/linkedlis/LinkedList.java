package core.dssolutions.linkedlis;

public class LinkedList {

    public static Node head;

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

  public static void main(String[] args) {
      LinkedList linkedList = new LinkedList();
      linkedList.head = new Node(1);
      linkedList.head.next=new Node(2);
      linkedList.head.next.next=new Node(3);
      linkedList.head.next.next.next=new Node(4);

      // Print the linked list ...

      Node node = head;

      while(node!=null){
      System.out.println(node.data);
      node=node.next;
      }

      // Now reverse the linked list ...

      node=head;
      Node previous = null;
      Node current = head;
      Node temp;

      while(current!=null){
         temp = previous;
         previous = current;
         current = current.next;
         previous.next = temp;
      }

      node = previous;

      while(node!=null){
          System.out.println(node.data);
          node=node.next;
      }

      deleteNode(1,previous);
      node = previous;

      while(node!=null){
          System.out.println(node.data);
          node=node.next;
      }

  }

  public static void deleteNode(int key,Node head){
        Node current = head;
        Node previous = null;

        if(current!=null && current.data==key){
            current = current.next;
        }

        while(current!=null && current.data!=key){
            previous = current;
            current = current.next;
        }

    if (current == null) return ;
    previous.next=current.next;
  }

}