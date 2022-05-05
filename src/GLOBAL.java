public class GLOBAL {
    public static final int[][] MOVE_LIST = {
            {2,1},
            {2,-1},
            {1,-2},
            {-1,-2},
            {-2,-1},
            {-2, 1},
            {-1,2},
            {1,2}
    };
    public static final int x = 0;
    public static final int y = 1;

    //couldn't access file on myconnect
    public static final int[][] accessiblity = {
            {2,3,4,4,4,4,3,2},
            {3,4,5,6,6,6,4,3},
            {4,5,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {4,6,8,8,8,8,6,4},
            {3,4,6,6,6,6,4,3},
            {2,3,4,4,4,4,3,2}
    };
}