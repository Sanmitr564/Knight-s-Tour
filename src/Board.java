import java.util.HashMap;
import java.util.Map;
//Hashmap was kinda redundant but im too lazy to replace it
import java.util.ArrayList;

public class Board {
    private final int[][] board;
    private final Knight knight;
    private final int[][] access;

    public Board() {
        board = new int[8][8];
        board[0][0] = 1;
        knight = new Knight();
        access = GLOBAL.accessiblity;
    }

    public boolean moveRandom() {
        int[] moveList = getArray();
        boolean canMove = false;
        for(int i : moveList){
            canMove = knight.checkMove(board, i);
            if(canMove){
                break;
            }
        }
        return canMove;
    }

    public boolean moveSmallest(){
        Map<Integer, ArrayList<Integer>> moves = arraySmallest();

        for(int i = 0; i<9; i++){
            for(int j = 0; j<moves.get(i).size(); j++){
                if(knight.checkMove(board, moves.get(i).get(j))){
                    updateAccess();
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getArray() {
        int[] ret = {9,9,9,9,9,9,9,9};
        int len = 0;
        while (len < 8) {
            int num = (int) (Math.random() * 8);
            boolean check = true;
            for (int i : ret) {
                if (i == num) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ret[len] = num;
                len++;
            }
        }
        return ret;
    }

    public void print(){
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
        for(int row = 0; row<board.length; row++){
            System.out.print(row+1 + "\t");
            for(int col = 0; col<board[row].length; col++){
                System.out.print(board[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println(knight.getTimesMoved());
    }

    private Map<Integer, ArrayList<Integer>> arraySmallest(){
        int[] moveList = getArray();
        Map<Integer, ArrayList<Integer>> sortedMoves = new HashMap<>();
        for(int i = 0; i<9; i++){
            sortedMoves.put(i, new ArrayList<>());
        }
        for(int i : moveList){
            int[] temp = knight.destination(board, i);
            if(temp[0]<0){
                continue;
            }
            int moveSize = access[temp[1]][temp[0]];
            sortedMoves.get(moveSize).add(i);
        }
        return sortedMoves;
    }

    private void updateAccess(){
        int[] moveList = getArray();
        for(int i : moveList){
            int[] temp = knight.destination(board, i);
            if((temp[0]>-1)){
                access[temp[1]][temp[0]]--;
            }
        }
    }

}