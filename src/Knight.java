public class Knight {
    private int x;
    private int y;
    private int timesMoved;

    public Knight() {
        x = 0;
        y = 0;
        timesMoved = 1;
    }

    public Knight(int x, int y) {
        this.x = x;
        this.y = y;
        timesMoved = 0;
    }

    public Knight(int x, int y, int timesMoved) {
        this.x = x;
        this.y = y;
        this.timesMoved = timesMoved;
    }

    public void move(int move) {
        x += GLOBAL.MOVE_LIST[move][GLOBAL.x];
        y += GLOBAL.MOVE_LIST[move][GLOBAL.y];
        timesMoved++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTimesMoved() {
        return timesMoved;
    }

    public boolean checkMove(int[][] board, int move) {
        if (canMove(board, move)) {
            move(move);
            board[y][x] = timesMoved;
            return true;
        }
        return false;
    }

    public boolean canMove(int[][] board, int move) {
        if (x + GLOBAL.MOVE_LIST[move][GLOBAL.x] < 0 || x + GLOBAL.MOVE_LIST[move][GLOBAL.x] > 7 || y + GLOBAL.MOVE_LIST[move][GLOBAL.y] < 0 || y + GLOBAL.MOVE_LIST[move][GLOBAL.y] > 7) {
            return false;
        } else if (board[y + GLOBAL.MOVE_LIST[move][GLOBAL.y]][(x + GLOBAL.MOVE_LIST[move][GLOBAL.x])] == 0) {
            return true;
        }
        return false;
    }

    /*

    public boolean checkMoveSmallest(int[][] board, int[] move){
        boolean bool = false;
        int[] moves = new int[8];
        int logLen = 0;
        for(int i : move){
            if(canMove(board, i)){
                bool = true;
                moves[logLen] = i;
                logLen++;
            }
        }

        return bool;
    }

     */

    public int[] destination(int[][] board, int move){
        if(!canMove(board, move)){
            return new int[] {-1,-1};
        }
        return new int[] {x + GLOBAL.MOVE_LIST[move][GLOBAL.x], y + GLOBAL.MOVE_LIST[move][GLOBAL.y]};
    }
}