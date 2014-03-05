package practices;

import util.ListNode;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
