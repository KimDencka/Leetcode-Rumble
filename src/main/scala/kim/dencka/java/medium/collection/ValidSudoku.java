package kim.dencka.java.medium.collection;

import java.util.*;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add(board[i][j] + " row " + i)) return false;
                    if (!seen.add(board[i][j] + " col " + j)) return false;
                    if (!seen.add(board[i][j] + " block " + i / 3 + "-" + j / 3)) return false;
                }
            }
        }
        return true;
    }
}
