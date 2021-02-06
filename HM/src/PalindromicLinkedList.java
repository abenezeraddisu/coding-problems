public class PalindromicLinkedList {
    public  static  boolean isPalindrome( ListNode head){
     ListNode fast = head;
     ListNode slow = head;
     while(fast!=null && fast.next!=null){
         fast = fast.next.next;
         slow = slow.next;
     }
     ListNode rev = helper(slow);
     ListNode copy = rev;
     while(rev!=null & head!=null){
         if(rev.val !=head.val) break;
         rev= rev.next;
         slow = slow.next;
     }
     helper(copy);
    return  true;


    }
    private static ListNode helper(ListNode list){
        ListNode next = null, prev = null;
        ListNode current = list;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
          return  prev;
    }
}
