public class LinkedListCycleStart {
    private static int helper(ListNode l){
        ListNode l2 = l;
        int length = 1;
        l2 = l.next;
        while(l2!=l){
            length++; l2 = l2.next;
        }
        return  length;
    }
    public static
    ListNode finder(ListNode list){
        ListNode fast = list;
        ListNode slow = list;
        while(fast !=null && fast.next !=null){
            fast = fast.next.next.next;
            slow = slow.next;
            if(slow == fast){
                int s= helper(slow);
                break;
            }

        }
      return helper2(list, helper(list)) ;
    }
    private static ListNode helper2(ListNode list, int len){
        ListNode slow = list;
        ListNode fast = list;
        for(int i = 0; i< len; i++){
            fast = fast.next;
        }
        while(fast!= slow){
            fast = fast.next;
            slow = slow.next;
        }
        return  slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.finder(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.finder(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.finder(head).val);
    }
}
