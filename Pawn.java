public class Pawn extends Piece{ //ENTIRE Class coded by Aman Modi, little bits added by Evan Wolfe
    public Pawn(int r, int c, String s, String t){
        super(r, c, s, t);
    }
    
    public boolean movePiece(int r, int c, String co){
        if(co.equals("w"))
        {
            if(getRow() - 2 == r && getCol()==c && getTwoMovement() && checkOpen(r,c)){
                changePosition(r, c);
                setRow(r);
                setTwoMovement(false);
                setEnPassant(true);
                return true;
            }else if((getRow() - 1 == r) && getCol()==c && checkOpen(r,c)){
                changePosition(r, c);
                setRow(r);
                setTwoMovement(false);
                setEnPassant(false);
                return true; //End of Ayaan
            }else if((getRow()-r == 1) && (Math.abs(getCol()-c) == 1) && (capturePiece(r,c) || passing(r,c))){ //Start of Ayaan
                if(passing(r,c))
                    if((r+1)%2==0 && c%2==0 || (r+1)%2 != 0 && c%2!=0)
                        array[(r+1)][c] = new DefaultWhite((r+1),c,"#");
                    else
                        array[(r+1)][c] = new DefaultBlack((r+1),c,"/");
                changePosition(r, c);
                setRow(r);
                setCol(c);
                setEnPassant(false);
                setTwoMovement(false);
            }else
                return false;
        }
        else
        {
            if(getRow() + 2 == r && getCol()==c && getTwoMovement() && checkOpen(r,c)){
                changePosition(r, c);
                setRow(r);
                setTwoMovement(false);
                setEnPassant(true);
                return true;
            }else if((getRow() + 1 == r) && getCol()==c && checkOpen(r,c)){
                changePosition(r, c);
                setRow(r);
                setTwoMovement(false);
                setEnPassant(false);
                return true;
            }else if((Math.abs(getCol()-c) == 1) && (capturePiece(r,c) || passing(r,c)) && (getRow()-r == -1)){ //Start of Ayaan
                if(passing(r,c))
                    if((r-1)%2==0 && c%2==0 || (r-1)%2 != 0 && c%2!=0)
                        array[(r-1)][c] = new DefaultWhite((r-1),c,"#");
                    else
                        array[(r-1)][c] = new DefaultBlack((r-1),c,"/");
                changePosition(r, c);
                setRow(r);
                setCol(c);
                setEnPassant(false);
                setTwoMovement(false);//End of Ayaan
            }else
                return false;
        }
        return true;
    }
    
    public boolean passing(int r, int c)
    {
        int checkSpace1 = 0;
        int checkSpace2 = 0;
        if(!(getCol() == 0) && !(getCol() == 7))
        {
            checkSpace1 = getCol()-1;
            checkSpace2 = getCol()+1;
            if(array[getRow()][checkSpace1].getEnPassant() == true)
                return true;
            else if(array[getRow()][checkSpace2].getEnPassant() == true)
                return true;
        }
        else if(getCol() == 0)
        {
            checkSpace2 = getCol()+1;
            if(array[getRow()][checkSpace2].getEnPassant() == true)
                return true;
        }
        else if(getCol() == 7)
        {
            checkSpace1 = getCol()-1;
            if(array[getRow()][checkSpace1].getEnPassant() == true)
                return true;
        }
        return false;
    }
}






