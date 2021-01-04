package LinkedList;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode addToTheLast(ListNode node) {
        this.next = node;
        return node;
    }

    static void printList(ListNode head)
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
