import java.util.ArrayList;
import java.util.List;

class boardSolver {
    char[][] board;
    int rowlen;
    int collen;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rowlen = board.length;
        this.collen = board[0].length;
        boolean b = false;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                b = backtrack(i, j, word, 0);
                if (b) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= rowlen) return true;
        if (row < 0 || row >= rowlen || col < 0 || col >= collen || board[row][col] != word.charAt(index)) return false;
        boolean toret = false;
        board[row][col] = '@';
        int[] rowoff = new int[]{0, 1, -1, 0};
        int[] coloff = new int[]{1, 0, 0, -1};
        for (int i = 0; i < 4; i++) {
            toret = backtrack(row + rowoff[i], col + coloff[i], word, index + 1);
            if (toret) break;
        }
        board[row][col] = word.charAt(index);
        return toret;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> holder = new ArrayList<>();
        holder.add(new ArrayList<>());
        for (int number : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : holder) {
                temp.add(new ArrayList<>(list) {{
                    add(number);
                }};
            }
            for (List<Integer> list : temp) {
                holder.add(list);
            }
        }
        return holder;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> holder = new ArrayList<>();
        holder.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return holder;
        for (int number : nums) {
            int holder_length = holder.size();
            for (int i = 0; i < holder_length; i++) {
                List<Integer> set = new ArrayList<>(holder.get(i));
                set.add(number);
                holder.add(set);
            }
        }
        return holder;
    }
}