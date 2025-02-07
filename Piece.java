import java.util.ArrayList;
public class Piece{
    //0=empty, 1=pawn, 2=knight, 3=bishop, 4=rook, 5=queen, 6=king
    private  int ident;
    private String name;
    private ArrayList<String> legalMove=new ArrayList<String>();
    private boolean isWhite;
    private static final char[] hash = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    public Piece(int i, boolean white){
        ident=i;
        isWhite=white;
        //white is cap
        if(isWhite){
            if(i==0) name="0";
            if(i==1) name="P";
            if(i==2) name="N";
            if(i==3) name="B";
            if(i==4) name="R";
            if(i==5) name="Q";
            if(i==6) name="K";
        }
        else{
            if(i==0) name="0";
            if(i==1) name="p";
            if(i==2) name="n";
            if(i==3) name="b";
            if(i==4) name="r";
            if(i==5) name="q";
            if(i==6) name="k";
        }
    }
    public boolean getWhite(){
        return isWhite;
    }
    
    public int getId(){
        return ident;
    }

    public String getName(){
        return name;
    }

    public void addPawnMoves(int row, int col){
        if(Board.board[row][col].getWhite()){
            String toAdd = new String();

            if (row-1 > -1 && col+1 < 8) {
                toAdd+=hash[col+1];
                toAdd+=Integer.toString(row-1);

                legalMove.add(toAdd);
            }
            toAdd = "";
            if (row - 1 > 0 && col - 1 > 0) {
                toAdd+=hash[col-1];
                toAdd+=Integer.toString(row-1);
                legalMove.add(toAdd);
            }
            toAdd = "";
            if(row-1>0){
                toAdd+=hash[col];
                toAdd+=Integer.toString(row-1);
                legalMove.add(toAdd);
            }
            toAdd = "";
            if(row-2>0){
                toAdd+=hash[col];
                toAdd+=Integer.toString(row-2);
                legalMove.add(toAdd);
            }
        }
        else{
            String toAdd = new String();

            if (row+1 < 8 && col+1 < 8) {
                toAdd+=hash[col+1];
                toAdd+=Integer.toString(row+1);

                legalMove.add(toAdd);
            }
            toAdd = "";
            if (row + 1 < 8 && col - 1 > 0) {
                toAdd+=hash[col-1];
                toAdd+=Integer.toString(row+1);
                legalMove.add(toAdd);
            }
            toAdd = "";
            if(row+1<8){
                toAdd+=hash[col];
                toAdd+=Integer.toString(row+1);
                legalMove.add(toAdd);
            }
            toAdd = "";
            if(row+2<8){
                toAdd+=hash[col];
                toAdd+=Integer.toString(row+2);
                legalMove.add(toAdd);
            }
        }
    }

    public void addKnightMoves(int row, int col){
        String toAdd = new String();
        if (row-1 > -1 && col+2 < 8) {
            toAdd+=hash[col+2];
            toAdd+=Integer.toString(row-1);
            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row-1 > -1 && col-2 > -1) {
            toAdd+=hash[col-2];
            toAdd+=Integer.toString(row-1);

            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row-2 > -1 && col+1 < 8) {
            toAdd+=hash[col+1];
            toAdd+=Integer.toString(row-2);

            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row-2 > -1 && col-1 > -1) {
            toAdd+=hash[col-1];
            toAdd+=Integer.toString(row-2);

            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row+1 < 8 && col+2 < 8) {
            toAdd+=hash[col+2];
            toAdd+=Integer.toString(row+1);
            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row+1 < 8 && col-2 > -1) {
            toAdd+=hash[col-2];
            toAdd+=Integer.toString(row+1);
            legalMove.add(toAdd);
        }
        toAdd = "";
        if (row+2 < 8 && col+1 < 8) {
            toAdd+=hash[col+1];
            toAdd+=Integer.toString(row+2);
            legalMove.add(toAdd);
        }
        
        toAdd = "";
        if (row+2 < 8 && col-1 > -1) {
            toAdd+=hash[col-1];
            toAdd+=Integer.toString(row+2);
            legalMove.add(toAdd);
        }
    }

    public void addBishopMoves(int row, int col){
        int tempr = row, tempc = col;
        String toAdd=new String();
        while (tempr+1<8&&tempc+1<8) { 
            //cannot move past a piece
            if (Board.board[tempr+1][tempc+1].getId()!=0) {
                toAdd+=hash[++tempc];
                toAdd+=Integer.toString(++tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr-1>-1&&tempc+1<8) { 
            //cannot move past a piece
            if (Board.board[tempr-1][tempc+1].getId()!=0) {
                toAdd+=hash[++tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(--tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr+1<8&&tempc-1>-1) { 
            //cannot move past a piece
            if (Board.board[tempr+1][tempc-1].getId()!=0) {
                toAdd+=hash[--tempc];
                toAdd+=Integer.toString(++tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr-1>-1&&tempc-1>-1) { 
            //cannot move past a piece
            if (Board.board[tempr-1][tempc-1].getId()!=0) {
                toAdd+=hash[--tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }
            
            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(--tempr);
            legalMove.add(toAdd);
        }
    }

    public void addRookMoves(int row, int col){
        String toAdd=new String();
        int tempr=row, tempc=col;
        
        while(tempr+1<8){
            if (Board.board[tempr+1][tempc].getId()!=0) {
                toAdd+=hash[tempc];
                toAdd+=Integer.toString(tempr+1);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempr-1>-1){
            if (Board.board[tempr-1][tempc].getId()!=0) {
                toAdd+=hash[tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[tempc];
            toAdd+=Integer.toString(tempr-1);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempc+1<8){
            if (Board.board[tempr][tempc+1].getId()!=0) {
                toAdd+=hash[tempc+1];
                toAdd+=Integer.toString(tempr);
                legalMove.add(toAdd);
                break;
            }
            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempc-1>-1){
            if (Board.board[tempr][tempc-1].getId()!=0) {
                toAdd+=hash[tempc-1];
                toAdd+=Integer.toString(tempr);
                legalMove.add(toAdd);
                break;
            }
            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(tempr);
            legalMove.add(toAdd);
        }
    }

    public void addQueenMoves(int row, int col){
        int tempr = row, tempc = col;
        String toAdd=new String();
        //rook moves
        while(tempr+1<8){
            if (Board.board[tempr+1][tempc].getId()!=0) {
                toAdd+=hash[tempc];
                toAdd+=Integer.toString(tempr+1);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempr-1>-1){
            if (Board.board[tempr-1][tempc].getId()!=0) {
                toAdd+=hash[tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[tempc];
            toAdd+=Integer.toString(tempr-1);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempc+1<8){
            if (Board.board[tempr][tempc+1].getId()!=0) {
                toAdd+=hash[tempc+1];
                toAdd+=Integer.toString(tempr);
                legalMove.add(toAdd);
                break;
            }
            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while(tempc-1>-1){
            if (Board.board[tempr][tempc-1].getId()!=0) {
                toAdd+=hash[tempc-1];
                toAdd+=Integer.toString(tempr);
                legalMove.add(toAdd);
                break;
            }
            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(tempr);
            legalMove.add(toAdd);
        }
        //bishop moves
        tempr = row; 
        tempc = col;
        toAdd="";
        while (tempr+1<8&&tempc+1<8) { 
            //cannot move past a piece
            if (Board.board[tempr+1][tempc+1].getId()!=0) {
                toAdd+=hash[++tempc];
                toAdd+=Integer.toString(++tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr-1>-1&&tempc+1<8) { 
            //cannot move past a piece
            if (Board.board[tempr-1][tempc+1].getId()!=0) {
                toAdd+=hash[++tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[++tempc];
            toAdd+=Integer.toString(--tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr+1<8&&tempc-1>-1) { 
            //cannot move past a piece
            if (Board.board[tempr+1][tempc-1].getId()!=0) {
                toAdd+=hash[--tempc];
                toAdd+=Integer.toString(++tempr);
                legalMove.add(toAdd);
                break;
            }

            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(++tempr);
            legalMove.add(toAdd);
        }
        toAdd="";
        tempr=row;
        tempc=col;
        while (tempr-1>-1&&tempc-1>-1) { 
            //cannot move past a piece
            if (Board.board[tempr-1][tempc-1].getId()!=0) {
                toAdd+=hash[--tempc];
                toAdd+=Integer.toString(--tempr);
                legalMove.add(toAdd);
                break;
            }
            
            toAdd+=hash[--tempc];
            toAdd+=Integer.toString(--tempr);
            legalMove.add(toAdd);
        }
    }

    public void addKingMoves(int row, int col){
        String toAdd=new String();
        if(row-1>-1){
            toAdd+=hash[col];
            toAdd+=Integer.toString(row-1);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(row+1<8){
            toAdd+=hash[col];
            toAdd+=Integer.toString(row+1);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(col-1>-1){
            toAdd+=hash[col-1];
            toAdd+=Integer.toString(row);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(col+1<8){
            toAdd+=hash[col+1];
            toAdd+=Integer.toString(row);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(row-1>-1&&col-1>-1){
            toAdd+=hash[col-1];
            toAdd+=Integer.toString(row-1);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(row-1>-1&&col+1<8){
            toAdd+=hash[col+1];
            toAdd+=Integer.toString(row-1);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(row+1<8&&col-1>-1){
            toAdd+=hash[col-1];
            toAdd+=Integer.toString(row+1);
            legalMove.add(toAdd);
        }
        toAdd="";
        if(row+1<8&&col+1<8){
            toAdd+=hash[col+1];
            toAdd+=Integer.toString(row+1);
            legalMove.add(toAdd);
        }
    }

    public boolean isValid(int row, int column,int newRow,int newCol){//parameters contain location of piece

        return false;
    }
}