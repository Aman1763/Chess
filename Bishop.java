public class Bishop extends Piece
{
    public Bishop(int r, int c, String s, String t)
    {
        super(r,c,s, t);
    }

    public boolean movePiece(int r, int c, String co)
    {
        if(!co.equals(getColor()))
            return false;
        else if((Math.abs(getCol()-c)==Math.abs(getRow()-r)) && checkBounds(r,c) && getRow()-r!=0 && getCol()-c!=0)
        {
            if(checkBounds(r,c))
            {
                if(checkForPiece(r,c,co))
                {
                    changePosition(r, c);
                    setRow(r);
                    setCol(c);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkForPiece(int r, int c, String co)
    {
        int checkRow = getRow();
        int checkCol = getCol();
        if((getRow()-r <= -1) && (getCol()-c <= -1))
        {
            while(checkRow<r && checkCol<c)
            {
                checkRow++;
                checkCol++;
            }
        }
        else if((getRow()-r >= 1) && (getCol()-c <= -1))
        {
            while(checkRow>r && checkCol<c)
            {
                checkRow--;
                checkCol++;
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
        }
        else if((getRow()-r <= -1) && (getCol()-c >= 1))
        {
            while(checkRow<r && checkCol>c)
            {
                checkRow++;
                checkCol--;
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
        }
        else if((getRow()-r >= 1) && (getCol()-c >= 1))
        {
            while(checkRow>r && checkCol>c)
            {
                checkRow--;
                checkCol--;
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
        }
        return true;
    }
    //(getRow()-r) == (getCol()-c) || (getRow()-r == -1*(getCol()-c))
}