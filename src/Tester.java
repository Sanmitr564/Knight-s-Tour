public class Tester {
    public static void main(String[] args){
        Board b1 = new Board();
        while(b1.moveSmallest());
        b1.print();
    }
}