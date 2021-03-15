public class DefaultWhite extends Piece
{
    public DefaultWhite(int r, int c, String s)
    {
        super(r,c,"w","#");
    }
    public boolean movePiece(int a, int b, String c)
    {
        return true;
    }
}
/*if((r%2 == 0 && c%2 == 1) || (r%2 == 1 && c%2 == 0))
            super(r,c,"black","/",a);
        else
            super(r,c,"white","#",a);
            */