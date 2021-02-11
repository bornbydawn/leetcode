package LinkedList;

public class CopyListWithRandomPointers {
    public static void main(String[] args) {
        Node seven = new Node(7);
        Node thirteen = new Node(13);
        seven.next = thirteen;
        Node eleven = new Node(11);
        thirteen.next = eleven;
        Node ten = new Node(10);
        eleven.next = ten;
        Node one = new Node(1);
        ten.next = one;

        thirteen.random = seven;
        eleven.random = one;
        ten.random = eleven;
        one.random = seven;

        seven.printList();
        System.out.println();
        CopyListWithRandomPointers object = new CopyListWithRandomPointers();
        Node copyHead = object.copyRandomList(seven);
        seven.printList();
        ;
        System.out.println();
        copyHead.printList();

    }

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        Node originalHead = head;

        Node newHead = null;

        while (head != null) {
            Node next = head.next;
            head.next = new Node(head.val);
            head.next.next = next;
            head = next;
        }

        newHead = originalHead.next;
        Node copy = newHead;
        Node toReturn = newHead;
        Node copyOfOriginalHead = originalHead;


        while (originalHead != null) {

            if (originalHead.random != null) {
                originalHead.next.random = originalHead.random.next;
            }
            if (originalHead.next != null) {
                originalHead = originalHead.next.next;
            }
        }


        while (copyOfOriginalHead != null && copy != null) {
            if(copyOfOriginalHead.next != null){
                copyOfOriginalHead.next = copyOfOriginalHead.next.next;
            }

            if(copy.next != null){
                copy.next = copy.next.next;
            }

            copyOfOriginalHead = copyOfOriginalHead.next;
            copy = copy.next;

        }
        return toReturn;
    }
}
