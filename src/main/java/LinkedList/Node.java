package LinkedList;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public void printList(){
        Node head = this;
        System.out.print("[");
        while(head != null){
            System.out.print("[" + head.val + "," + (head.random != null ? head.random.val + "" : "null") + "]");
            if(head.next != null) System.out.print(",");
            head = head.next;
        }
        System.out.print("]");
    }
}
