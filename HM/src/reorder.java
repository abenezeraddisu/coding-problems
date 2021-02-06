public class reorder {
    public  static  void reorder(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = helper(slow);
        ListNode original = head;
        while(original!=null && reversed!=null){
            ListNode temp = original.next;
            original.next = reversed;
            original = temp;
            temp = reversed.next;
            reversed.next = original;
            reversed = temp;
        }
if(original.next!=null) original.next= null;
    }
    private static  ListNode helper(ListNode list){
        ListNode prev = null, next = null;
        ListNode current = list;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder.reorder(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
