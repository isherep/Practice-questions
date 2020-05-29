public class TicTacToe {


        private static final int FIRST_PLAYER = 1; // X,
        private static final int SECOND_PLAYER = 2; // O
        private int[] rows;
        private int[] cols;
        private int diagonalUp;
        private int diagonalDown;
        private int size;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            // initialize new matrix
            this.size = n;
            rows = new int[n];
            cols = new int[n];
            diagonalUp = 0;
            diagonalDown = 0;
            // rows count from 1 not 0
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            int amountToAdd = 0;
            if(player == 1){
                amountToAdd =1;
            } else { amountToAdd =-1;}
            rows[row] += amountToAdd;
            // ad one mark in the given column
            cols[col] +=amountToAdd;
            if(row == col){
                diagonalUp += amountToAdd;
            }
            if(col == size-row -1){
                diagonalDown += amountToAdd;
            }
            // if any element in the row value is equal to
            if (Math.abs(rows[row]) == size ||
                    Math.abs(cols[col]) == size ||
                    Math.abs(diagonalUp) == size  ||
                    Math.abs(diagonalDown) == size) {

                return player;
            }else{
                return 0;
            }
        }



}
