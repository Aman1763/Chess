 public class Knight extends Piece{ //ENTIRE Class coded by Ayaan Nazir
    private static int newr;
    private static int newc;
    public Knight(int r, int c, String s, String t){
        super(r, c, s, t);
    }    
    public boolean movePiece(int r, int c, String co){
        newr = getRow();
        newc = getCol(); 
        if(!co.equals(getColor()))
                return false;  
        else if((Math.abs(getRow()-r)*Math.abs(getCol()-c)) == 2 && checkOpen(r,c) && checkBounds(r,c)){
                changePosition(r, c);
                return true;
        }else if((Math.abs(getRow()-r) == 2) && (Math.abs(getCol()-c) == 1) && capturePiece(r,c) && checkBounds(r,c)){
                changePosition(r, c);
                return true;
        }else if((Math.abs(getRow()-r) == 1) && (Math.abs(getCol()-c) == 2) && capturePiece(r,c) && checkBounds(r,c)){
                changePosition(r, c);
                return true;
        }else
                return false;
    }
    
    public boolean capturePiece(int r, int c) //is still in progress!
    {
        if(!((array[r][c].getPieceType().equals("#") || array[r][c].getPieceType().equals("/")) && array[r][c].getColor().equals(getColor())))
            return true;
        else 
            return false;
    }    
}





