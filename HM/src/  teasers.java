import java.util.*;

class letter {
    Map<String, String> holder = new HashMap<>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return output;
        helper_backtracking("", digits);
        return output;
    }

    private void helper_backtracking(String combination, String next_digits) {
        if (next_digits.length() == 0) output.add(combination);
        String digit = next_digits.substring(0, 1);
        String letters = holder.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String s = letters.substring(i, i + 1);
            helper_backtracking(combination + s, next_digits.substring(1));
        }

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> holder = new ArrayList<>();
        if (root == null) return holder;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean on = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> h = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (on) h.add(t.val);
                else h.add(0, t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            on = !on;
            holder.add(h);
        }
        return holder;
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Node left = root;
        while (Node.left != null) {
            Node head = left;
            head.left.next = head.right;
            if (head.next != null) {
                head.right.next = head.next.left;
            }
            head = head.next;
        }
        left = left.left;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pb;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, even_head_holder = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even_head_holder;
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode a = l1;
        ListNode b = l2;
        int carry = 0;
        ListNode curr = dummy;
        while (a != null || b != null) {
            int a_val = a == null ? 0 : a.val;
            int b_val = b == null ? 0 : b.val;
            int sum = a_val + b_val + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry == 1) curr.next = new ListNode(1);
        return dummy.next;

    }
}
