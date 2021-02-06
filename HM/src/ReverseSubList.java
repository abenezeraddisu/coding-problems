class ListNode {
    int val = 0;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q){
        if (p == q)
            return head;
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;
        lastNodeOfSubList.next = current;
        return head;
    }
    public  static ListNode rev(ListNode head, int p, int q){
        ListNode prev = null, current = head;
        for(int i = 1; i < p && current.next!=null ; i++){
           prev = current;
           current = current.next;

        }
        ListNode justbefore = prev, lastbefore = current, next = null;
        for(int i = 0; current.next != null && i< q-p +1; i++){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(justbefore!=null) justbefore.next = prev;
        else head = prev;
        if(lastbefore!=null) lastbefore.next = current;

        return  head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
