public class hasCycle {
    public static boolean has(ListNode l){
        ListNode slow = l;
        ListNode fast = l;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next.next;
            slow = slow.next.next;
            //if(slow == false) return  true;

        }
        return  false;
    }
}
