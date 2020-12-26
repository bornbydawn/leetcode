package LinkedList;

public class SwapNodesInPair {

    public static void main(String[] args) {


    }

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;
        return reverse(head, 2);
    }

    private ListNode reverse(ListNode head, int k){

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        int count = 0;

        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null){
            head.next = reverse(next, k);
        }

        return prev;

    }
    
}
