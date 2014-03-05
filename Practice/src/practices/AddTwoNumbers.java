package practices;

import util.*;

/*
 * 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode iter1 = l1, iter2 = l2;
        ListNode list = null, tail = null;
    
        int carry = 0;
        while (iter1 != null || iter2 != null || carry != 0) {
            int num1 = iter1 == null ? 0 : iter1.val;
            int num2 = iter2 == null ? 0 : iter2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;
            if (list == null) {
                list = new ListNode(sum);
                tail = list;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
    
            iter1 = iter1 == null ? null : iter1.next;
            iter2 = iter2 == null ? null : iter2.next;
        }
    
        return list;
    }
}
