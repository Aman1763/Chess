public class Queen extends Piece
{
    public Queen(int r, int c, String s, String n)
    {
        super(r,c,s,n);
    }
    public boolean movePiece(int r, int c, String co){
        if(!co.equals(getColor()))
            return false;
        else if((Math.abs(getCol()-c)==Math.abs(getRow()-r)) && checkBounds(r,c) && getRow()-r!=0 && getCol()-c!=0 && checkForPiece(r,c)){
            changePosition(r,c);
            setRow(r);
            setCol(c);
            return true;
        }else if(getCol()==c && checkBounds(r,c) && getRow()-r!=0 && checkForPiece(r,c)){
            changePosition(r,c);
            setRow(r);
            setCol(c);
            return true;
        }else if(getRow()==r && checkBounds(r,c) && getCol()-c!=0 && checkForPiece(r,c)){
            changePosition(r,c);
            setRow(r);
            setCol(c);
            return true;
        }return false;
    }
    public boolean checkForPiece(int r, int c)
    {
        int checkRow = getRow();
        int checkCol = getCol();
        if((getRow()-r <= -1) && (getCol()-c <= -1))
        {
            while(checkRow!=r && checkCol!=c)
            {
                checkRow++;
                checkCol++;
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
        }
        else if((getRow()-r >= 1) && (getCol()-c <= -1))
        {
            while(checkRow!=r && checkCol!=c)
            {
                checkRow--;
                checkCol++;
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/") || capturePiece(r,c)))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
        }
        else if((getRow()-r <= -1) && (getCol()-c >= 1))
        {
            while(checkRow!=r && checkCol!=c)
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
            while(checkRow!=r && checkCol!=c)
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
        else if (getCol()-c == 0)
            {
            if(getRow() > r){
                while(checkRow!=r)
                {
                checkRow--;
                if(checkBounds(checkRow, checkCol))
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }           
            }
            }
            else if(getRow() < r){
                while(checkRow!=r)
                {
                checkRow++;
                if(checkBounds(checkRow, checkCol))
                if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                {
                    if(array[checkRow][checkCol].getColor().equals(getColor()))
                        return false;
                }
            }
            }
        }
        else if (getRow()-r == 0)
            {                
                if(getCol() > c){
                    while(checkCol!=c){
                    checkCol--;
                    if(checkBounds(checkRow, checkCol))
                    if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                    {
                        if(array[checkRow][checkCol].getColor().equals(getColor()))
                            return false;
                    }
                }}
                
                
                else if(getCol() < c){
                    while(checkCol!=c)
                    checkCol++;
                    if(checkBounds(checkRow, checkCol))
                    if(!(array[checkRow][checkCol].getPieceType().equals("#") || array[checkRow][checkCol].getPieceType().equals("/")))
                    {
                        if(array[checkRow][checkCol].getColor().equals(getColor()))
                            return false;
                    }
            }
        }     
    
        return true;
   }
}








