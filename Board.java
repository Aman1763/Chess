
// Version 2-28-20 11:15 AM - Ayaan Nazir
//Beginning of Alex
 import static java.lang.System.*;
public class Board
{
    public static Piece[][] board1 = new Piece[8][8];
    //String[] args
    //String p1, String p2
 public static void create(String p1, String p2)
 {
     //Don't reset screen here it already does that
     int numSpace = 8;
     char letSpace = 'A';
     out.println( p1 + "'s score = " + "0" + "       " + p2 + "'s score = " + "0\n\n");
     for(int i = 0;i<board1.length;i++)
     {
         System.out.print(numSpace + "     ");
         numSpace--;                                              //
         
         for(int j = 0;j<board1.length;j++)
         { 
             switch(i){
              case 0:switch(j){
                  case 0:board1[i][j] = new Rook(i,j,"b","r");break; 
                  case 1:board1[i][j] = new Knight(i,j,"b","n");break; 
                  case 2:board1[i][j] = new Bishop(i,j,"b","b");break; 
                  case 3:board1[i][j] = new Queen(i,j,"b","q");break; 
                  case 4:board1[i][j] = new King(i,j,"b","k");break; 
                  case 5:board1[i][j] = new Bishop(i,j,"b","b");break; 
                  case 6:board1[i][j] = new Knight(i,j,"b","n");break;  
                  case 7:board1[i][j] = new Rook(i,j,"b","r");};break;
                  
              case 1:switch(j){
                  case 0:board1[i][j] = new Pawn(i,j,"b","p");
                  case 1:board1[i][j] = new Pawn(i,j,"b","p"); 
                  case 2:board1[i][j] = new Pawn(i,j,"b","p"); 
                  case 3:board1[i][j] = new Pawn(i,j,"b","p"); 
                  case 4:board1[i][j] = new Pawn(i,j,"b","p"); 
                  case 5:board1[i][j] = new Pawn(i,j,"b","p"); 
                  case 6:board1[i][j] = new Pawn(i,j,"b","p");  
                  case 7:board1[i][j] = new Pawn(i,j,"b","p");};break;
                  
                  case 6:switch(j){
                  case 0:board1[i][j] = new Pawn(i,j,"w","P");
                  case 1:board1[i][j] = new Pawn(i,j,"w","P"); 
                  case 2:board1[i][j] = new Pawn(i,j,"w","P"); 
                  case 3:board1[i][j] = new Pawn(i,j,"w","P"); 
                  case 4:board1[i][j] = new Pawn(i,j,"w","P"); 
                  case 5:board1[i][j] = new Pawn(i,j,"w","P"); 
                  case 6:board1[i][j] = new Pawn(i,j,"w","P");  
                  case 7:board1[i][j] = new Pawn(i,j,"w","P");};break;              
                  
              
              case 7:switch(j){
                  case 0:board1[i][j] = new Rook(i,j,"w","R");break; 
                  case 1:board1[i][j] = new Knight(i,j,"w","N");break; 
                  case 2:board1[i][j] = new Bishop(i,j,"w","B");break; 
                  case 3:board1[i][j] = new Queen(i,j,"w","Q");break; 
                  case 4:board1[i][j] = new King(i,j,"w","K");break; 
                  case 5:board1[i][j] = new Bishop(i,j,"w","B");break; 
                  case 6:board1[i][j] = new Knight(i,j,"w","N");break;  
                  case 7:board1[i][j] = new Rook(i,j,"w","R");};break;      
              }
                  
             if(i >= 2 && i <= 5){
             if(i%2==0 && j%2==0 || i%2 != 0 && j%2!=0)
              board1[i][j] = new DefaultWhite(i,j,"#");
             else
              board1[i][j] = new DefaultBlack(i,j,"#");
            }
            System.out.print(board1[i][j].getPieceType()+ " | " );
          }
          System.out.println("\n     ---|---|---|---|---|---|---|---|");
        }
        System.out.print("\n\n      A   B   C   D   E   F   G   H");
    }
    // End of Alex
    //Alex’s edit of jon’s code
    public static void update(String n1, String n2, boolean turn, int c1, int r1)
    {
       out.print('\u000c');
       if(turn)
            out.println("It is now " + n1 + "'s turn.\n");
       else
            out.println("It is now " + n2 + "'s turn.\n");
       int numSpace = 8;
       for(int r = 0;r<board1.length;r++)
       { 
         System.out.print(numSpace + "     ");
         numSpace--;
         for(int c = 0;c<board1.length;c++)
         { 
	if(!((r==r1) && (c==c1)))
                board1[r][c].setEnPassant(false);
            System.out.print(board1[r][c].getPieceType()+ " | ");
         }
         System.out.println("\n     ---|---|---|---|---|---|---|---|");
       }
       System.out.print("\n\n      A   B   C   D   E   F   G   H");
       //Multiplayer.setPosition(board1);
    }
}
