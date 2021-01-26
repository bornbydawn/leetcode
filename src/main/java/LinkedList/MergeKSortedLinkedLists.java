package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {


    public static void main(String[] args) {
        MergeKSortedLinkedLists mergeKSortedLinkedLists = new MergeKSortedLinkedLists();
        ListNode[] listNodes = new ListNode[2];
        ListNode list1 = new ListNode(5);
        list1.addToTheLast(new ListNode(10)).addToTheLast(new ListNode(15));


        ListNode list2 = new ListNode(2);
        list2.addToTheLast(new ListNode(3)).addToTheLast(new ListNode(20));

        //listNodes[0] = list1;
        //listNodes[1] = list2;

        ListNode merged = mergeKSortedLinkedLists.mergeKLists(listNodes);
        ListNode.printList(merged);

    }

//    class ListNodeComparator implements Comparator<ListNode> {
//        public int compare(ListNode s1, ListNode s2) {
//            return s1.val - s2.val;
//        }
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        if(lists.length == 0) return null;

        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>(lists.length, Comparator.comparing(listNode -> listNode.val));

        for (ListNode head : lists) {
            if(head != null)
            listNodePriorityQueue.add(head);
        }


        while (!listNodePriorityQueue.isEmpty()) {
            ListNode currentElement = listNodePriorityQueue.poll();
            tail.next = currentElement;
            tail = tail.next;
            currentElement = currentElement.next;
            if (currentElement != null)
                listNodePriorityQueue.add(currentElement);
        }
        tail.next = null;

        return dummyNode.next;
    }
}
