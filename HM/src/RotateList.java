public class RotateList {
    public static ListNode rotate( ListNode head, int rot){
        if(head ==null|| head.next == null|| rot<=0){
            return  head;
        }
        int len = 1;
        ListNode last = head;

        while(last.next!=null){
            last = last.next;
            len++;
        }
        last.next = head;
        int skip = len-rot;
        ListNode lst = head;
        for(int i = 0; i< skip-1; i++){
            lst = lst.next;
        }
        head = lst.next;
        lst.next = null;
        return  head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
