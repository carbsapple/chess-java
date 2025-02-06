public class Board{
    static Piece[][] board=new Piece[8][8];
    public Board(){
        board[0][0]=new Piece(4,false);
        board[0][1]=new Piece(2,false);
        board[0][2]=new Piece(3,false);
        board[0][3]=new Piece(5,false);
        board[0][4]=new Piece(6,false);
        board[0][5]=new Piece(3,false);
        board[0][6]=new Piece(2,false);
        board[0][7]=new Piece(4,false);
        for(int i=0;i<8;i++){
            board[1][i]=new Piece(1,false);
        }
        for(int i=0;i<8;i++){
            board[6][i]=new Piece(1, true);
        }
        board[7][0]=new Piece(4, true);
        board[7][1]=new Piece(2, true);
        board[7][2]=new Piece(3, true);
        board[7][3]=new Piece(5, true);
        board[7][4]=new Piece(6, true);
        board[7][5]=new Piece(3, true);
        board[7][6]=new Piece(2, true);
        board[7][7]=new Piece(4, true);
    }
    public static void showBoard(){
        
        for(int i=0;i<board.length;i++){
            System.out.print(board.length-i);
               for(int j=0;j<board[0].length;j++){
                    System.out.print(board[i][j].getName());
               }
               System.out.println();
        }
        System.out.println("ABCDEFGH");
    }
}
