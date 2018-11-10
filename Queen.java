//Anthony Xiang
// AP CS Period 9

public class Queen extends Piece {
  
  public Queen (boolean boole, Board board) {
    super(boole, board);
  }
  
  public Queen (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
  }
  
   public boolean move(Location dest) {
     
     Location src = super.getMyBoard().locationOf(this);
     boolean ydirectionBoole = src.getCol() > dest.getCol();            // if true, source righter than dest
     boolean xdirectionBoole = src.getRow() > dest.getRow();            // if true, source lower than dest
     int xmultiplier;
     int ymultiplier;
     int movediag = 0;
     
     if ((Math.abs(dest.getRow() - src.getRow()) == Math.abs(dest.getCol() - src.getCol())))          //    if queen moves diagonally
               movediag = 1;
       else if ((dest.getRow() - src.getRow() == 0 && dest.getCol() - src.getCol() != 0) || (dest.getCol() - src.getCol() == 0 && dest.getRow() - src.getRow() != 0))  // if queen moves vert/horizontally
               movediag = -1;
     
   if (super.getMyBoard() != null) {                           //if the board is present
    if (super.getMyBoard().isValid(dest)) {               // if the dest is usable
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       if (movediag == -1 || movediag == 1) {
         if (super.getMyBoard().isEmpty(dest) || super.getMyBoard().getPiece(dest).isWhite() != super.isWhite()) {   // if the destination is valid
                   if (xdirectionBoole)
                     xmultiplier = -1;
                   else
                     xmultiplier = 1;
                   if (ydirectionBoole)
                     ymultiplier = -1;
                   else
                     ymultiplier = 1;
           if (movediag == 1) {
         for (int i=1; i < Math.abs(src.getRow() - dest.getRow()); i++) {               // check spaces when the queen moves diagonally
           if (!super.getMyBoard().isEmpty(new Location(src.getRow() + xmultiplier*i, src.getCol() + ymultiplier*i))) 
              return false;
            
           }
          }
           else if (movediag == -1 && dest.getRow() == src.getRow()) {                 // if the rook moves left/right 
          for (int i=1; i < Math.abs(src.getCol() - dest.getCol()); i++) {               
           if (!super.getMyBoard().isEmpty(new Location(src.getRow(), src.getCol() + xmultiplier*i))) 
              return false;
          }}
          else if (movediag == -1 && dest.getCol() == src.getCol()) {                   // if the rook moves up/down
            for (int j=1; j < Math.abs(src.getRow() - dest.getRow()); j++) {               
           if (!super.getMyBoard().isEmpty(new Location(src.getRow() + xmultiplier*j, src.getCol()))) 
              return false;
            }
           }
           super.getMyBoard().movePiece(src, dest);        // if everything is valid
           return true;
        }
       }
     }
   }
  }
   return false;
 }
   
   public String toString() {
    if (isWhite())
      return "q";
    else
      return "Q";
  }
   
}