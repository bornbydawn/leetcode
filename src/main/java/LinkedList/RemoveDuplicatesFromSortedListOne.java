package LinkedList;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicatesFromSortedListOne {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.addToTheLast(new ListNode(1))
                .addToTheLast(new ListNode(2))
                .addToTheLast(new ListNode(3))
                .addToTheLast(new ListNode(4))
                .addToTheLast(new ListNode(4))
                .addToTheLast(new ListNode(5));

        RemoveDuplicatesFromSortedListOne removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedListOne();
        list1 = removeDuplicatesFromSortedList.deleteDuplicates(list1);
        ListNode.printList(list1);
    }
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode mover = head;
        ListNode prev = head;
        mover = mover.next;
        while(mover != null){
            if(mover.val == prev.val){
                prev.next = mover.next;
                mover = mover.next;
            }
            else{
                mover = mover.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
