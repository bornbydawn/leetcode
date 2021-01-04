package LinkedList;

public class MergeTwoSortedLinkedLists {



    public static void main(String[] args) {
        MergeTwoSortedLinkedLists mergeTwoSortedLinkedLists = new MergeTwoSortedLinkedLists();
        ListNode list1 = new ListNode(5);
        list1.addToTheLast(new ListNode(10)).addToTheLast(new ListNode(15));


        ListNode list2 = new ListNode(2);
        list2.addToTheLast(new ListNode(3)).addToTheLast(new ListNode(20));

        ListNode merged = mergeTwoSortedLinkedLists.mergeTwoLists(list1, list2);
        ListNode.printList(merged);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while(true){
            if(l1 == null){
                tail.next = l2;
                break;
            }

            if(l2 == null){
                tail.next = l1;
                break;
            }

            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        return dummyNode.next;
    }
}
