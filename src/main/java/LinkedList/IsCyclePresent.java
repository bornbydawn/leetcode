package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IsCyclePresent {

    public static void main(String[] args) {
        IsCyclePresent object = new IsCyclePresent();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        head.addToTheLast(second).addToTheLast(new ListNode(0)).addToTheLast(new ListNode(-4)).addToTheLast(second);
        System.out.println(object.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {

        if(head == null) return false;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }

//    public boolean hasCycle(ListNode head) {
//
//        if(head == null) return false;
//        Set<ListNode> visited = new HashSet<>();
//        visited.add(head);
//        head = head.next;
//        while(head != null){
//            if(visited.contains(head)){
//                return true;
//            }
//            visited.add(head);
//            head = head.next;
//        }
//        return false;
//    }
}
