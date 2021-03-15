 
//Coded by alex (a bit by jon)
import java.util.ArrayList;
public class King extends Piece
{
    public King(int r, int c, String s, String n)
    {
        super(r, c, s, n);
    }
    public boolean movePiece(int r, int c, String co)
    {
        if(!co.equals(getColor()))
            return false;
        else if((((Math.abs(getRow()-r)*Math.abs(getCol()-c))==1) || (Math.abs(getRow()-r)+Math.abs(getCol()-c))==1)&& (checkOpen(r,c) || !co.equals(array[r][c].getColor()))){
            changePosition(r,c);
            setRow(r);
            setCol(c);
            if(co.equals("w"))
            {
                Multiplayer.wKingr=r;//updates the white King’s position
                Multiplayer.wKingc=c;//updates the white King’s position
            }
            else
            {
                Multiplayer.bKingr=r;//updates the black King’s position
                Multiplayer.bKingc=c;//updates the black King’s position
            }
            setMoved(true);
            return true;
         }
        else if(castling(r, c,co) && getRow()==r){
            changePosition(r,c);
            setRow(r);
            setCol(c);
            if(co.equals("w"))
            {
                Multiplayer.wKingr=r;//updates the white King’s position
                Multiplayer.wKingc=c;//updates the white King’s position
            }
            else
            {
                Multiplayer.bKingr=r;//updates the black King’s position
                Multiplayer.bKingc=c;//updates the black King’s position
            }
            setMoved(true);
            return true;
        }
        return false;
    }
 
    public boolean castling(int r, int c,String co) 
    //Be sure to check  = for rook movements and threats through check  =
    {
        if(!getMoved())
        {
            if(co.equals("w"))
            {
                if(getCol()-c==-2 && getRow()==r)
                    if(!array[7][7].getMoved())
                    {
                        for(int i=c;i<7;i++)
                            if(checkForCheck(r,i,co) || !checkOpen(r,i))
                                return false;
                        array[r][c-1] = new Rook(r,c-1,"w","R");
                        array[r][c-1].setMoved(true);
                        array[7][7] = new DefaultWhite(7,7,"#");
                        return true;
                    }
                if(getCol()-c==2 && getRow()==r)
                    if(!array[7][0].getMoved())
                    {
                        for(int i=c;i>0;i--)
                            if(checkForCheck(r,i,co) || !checkOpen(r,i))
                                return false;
                        array[r][c+1] = new Rook(r,c-1,"w","R");
                        array[r][c+1].setMoved(true);
                        array[0][7] = new DefaultBlack(0,7,"/");
                        return true;
                    }
            }
            else
            {
                if(getCol()-c==-2 && getRow()==r)
                    if(!array[0][7].getMoved())
                    {
                        for(int i=c;i<7;i++)
                            if(checkForCheck(r,i,co) || !checkOpen(r,i))
                                return false;
                        array[r][c-1] = new Rook(r,c-1,"b","r");
                        array[r][c-1].setMoved(true);
                        array[0][7] = new DefaultBlack(0,7,"/");
                        return true;
                    }
                if(getCol()-c==2 && getRow()==r)
                    if(!array[0][0].getMoved())
                    {
                        for(int i=c;i>0;i--)
                            if(checkForCheck(r,i,co) || !checkOpen(r,i))
                                return false;
                        array[r][c+1] = new Rook(r,c-1,"b","r");
                        array[r][c+1].setMoved(true);
                        array[0][0] = new DefaultWhite(0,0,"#");
                        return true;
                    }
            }
        }
        return false;
    }
}




