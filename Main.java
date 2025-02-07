import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    private static final Map<Character, Integer> revHash = new HashMap<>();
    private static final int[] revRHash = {-1, 0, 1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Board board = new Board();
        Board.showBoard();

        revHash.put('A', 0);
        revHash.put('B', 1);
        revHash.put('C', 2);
        revHash.put('D', 3);
        revHash.put('E', 4);
        revHash.put('F', 5);
        revHash.put('G', 6);
        revHash.put('H', 7);

        revHash.put('a', 0);
        revHash.put('b', 1);
        revHash.put('c', 2);
        revHash.put('d', 3);
        revHash.put('e', 4);
        revHash.put('f', 5);
        revHash.put('g', 6);
        revHash.put('h', 7);
        
        while (true) { 
            System.out.println("Enter the position of the piece you want to move: ");
            String piece = scnr.next();
            System.out.println("Enter the position where you want to move the piece: ");
            String move = scnr.next();
            if (Piece.isValid(revHash.get(piece.charAt(0)), revRHash[piece.charAt(1) - '0'], revHash.get(move.charAt(0)), revRHash[move.charAt(1) - '0'])) {
                Piece temp = Board.board[revHash.get(piece.charAt(0))][revRHash[piece.charAt(1) - '0']];
                Board.board[revHash.get(move.charAt(0))][revRHash[move.charAt(1) - '0']] = temp;
                Board.board[revHash.get(piece.charAt(0))][revRHash[piece.charAt(1) - '0']] = new Piece(0, false);
                Board.showBoard();
            } else {
                System.out.println("Invalid move. Try again.");
            }
            break;      
        }

        scnr.close();
    }
}
