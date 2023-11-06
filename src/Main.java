import java.math.*;
import java.util.*;

public class Main {
    public static HashMap<String, Lattice> board = new HashMap<String, Lattice>(64); //board
    public static void main(String[] args) {
        //Build Board
        Board board = new Board();
        board.printBoard();

        //Moves
        int minutes = 0;
        ArrayList<String[]> moves = new ArrayList<>(180);
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[]{"", ""};
        while(!input[0].equals("TERMINATE")){
            System.out.println("You are currently at " + board.currentPos + " and have traveled " + minutes + " minutes. Where would you like to move, and for how long? Answer should be as such: (new spot) minutes ");
            input = scanner.nextLine().split(" ");
            if(input[0].equals("back")){
                board.goBack();
            }else if(input[0].equals("moves")){
                for (String[] move : moves) {
                    System.out.println(Arrays.toString(move));
                }
            }else if(board.validMove(input[0])){
                moves.add(input);
                board.moveKnight(input[0], Integer.parseInt(input[1]));
                minutes+= Integer.parseInt(input[1]);
                System.out.println("Knight moved");
                board.printBoard();
            }else{
                System.out.println("Not a valid move. Please enter another move. ");
            }
        }
        System.out.println("Minutes Traveled: ");


    }
}