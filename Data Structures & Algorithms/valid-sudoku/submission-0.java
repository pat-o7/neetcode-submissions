class Solution {
    public boolean isValidSudoku(char[][] board) {

        // hashsets
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // initialize
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                // put in rows set
                if (!(rows[row].add(board[row][col]))) {
                    return false;
                }

                // put in cols set
                if (!(cols[col].add(board[row][col]))) {
                    return false;
                }

                // put in boxes set
                int box = getBoxNumer(row, col);
                if (!(boxes[box].add(board[row][col]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getBoxNumer(int row, int col) {
        if (0 <= col && col <= 2) {
            if (0 <= row && row <= 2) {
                return 0;
            } else if (3 <= row && row <= 5) {
                return 1;
            } else if (6 <= row && row <= 8) {
                return 2;
            }
        } else if (3 <= col && col <= 5) {
            if (0 <= row && row <= 2) {
                return 3;
            } else if (3 <= row && row <= 5) {
                return 4;
            } else if (6 <= row && row <= 8) {
                return 5;
            }            
        } else if (6 <= col && col <= 8) {
            if (0 <= row && row <= 2) {
                return 6;
            } else if (3 <= row && row <= 5) {
                return 7;
            } else if (6 <= row && row <= 8) {
                return 8;
            }     
        }
        throw new IllegalArgumentException("couldnt get box number");
    }
}
