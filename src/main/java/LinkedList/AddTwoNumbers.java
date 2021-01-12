package LinkedList;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//        ListNode listNode1 = new ListNode(2);
//        listNode1.addToTheLast(new ListNode(4)).addToTheLast(new ListNode(3));
//
//
//        ListNode listNode2 = new ListNode(5);
//        listNode2.addToTheLast(new ListNode(6)).addToTheLast(new ListNode(4));


        ListNode listNode1 = new ListNode(9);
        listNode1.addToTheLast(new ListNode(9)).addToTheLast(new ListNode(9)).addToTheLast(new ListNode(9));


        ListNode listNode2 = new ListNode(9);
        listNode2.addToTheLast(new ListNode(9));


        ListNode answer = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        ListNode.printList(answer);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum;

        ListNode listNode = new ListNode(-1);
        ListNode last = listNode;

        while(l1 != null && l2 != null){
            sum = (l1.val + l2.val + carry)%10;
            carry = (l1.val + l2.val + carry)/10;
            last.next = new ListNode(sum);
            last = last.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry)/10;
            last.next = new ListNode(sum);
            last = last.next;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry)/10;
            last.next = new ListNode(sum);
            last = last.next;
            l2 = l2.next;
        }
        if(carry != 0){
            last.next = new ListNode(carry);
        }

        return listNode.next;
    }
}
