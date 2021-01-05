package LinkedList;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class DeleteDuplicatesFromSortedList {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.addToTheLast(new ListNode(1))
               .addToTheLast(new ListNode(2))
                .addToTheLast(new ListNode(3))
                .addToTheLast(new ListNode(4))
                .addToTheLast(new ListNode(4))
                .addToTheLast(new ListNode(5));

        DeleteDuplicatesFromSortedList deleteDuplicatesFromSortedList = new DeleteDuplicatesFromSortedList();
        list1 = deleteDuplicatesFromSortedList.deleteDuplicates(list1);
        ListNode.printList(list1);
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-101);
        if(head == null || head.next == null){
            return head;
        }
        dummy.next = head;

        ListNode mover = head;
        ListNode prev = dummy;
        int prevValue = head.val;
        ListNode next = mover.next;

        while(next != null){
            if(next.val == prevValue){
                while(next != null && next.val == prevValue){
                    next = next.next;
                }
                prev.next = next;
                if(next != null){
                    mover = next;
                    prevValue = mover.val;
                    next = next.next;
                }
            }


            else{
                prev = mover;
               mover = mover.next;
               next = next.next;
               prevValue = mover.val;
            }
        }
        return dummy.next;
    }
}
