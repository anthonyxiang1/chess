//Anthony Xiang
// AP CS Period 9

public class Rook extends Piece {
  
  private boolean moveBoole;
  
  public Rook (boolean boole, Board board) {
    super(boole, board);
    moveBoole = false;
  }
  
  public Rook (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
    moveBoole = false;
  }
  
   public boolean move(Location dest) {
     
     Location src = super.getMyBoard().locationOf(this);
     boolean ydirectionBoole = src.getCol() > dest.getCol();            // if true, source lower than dest
     boolean xdirectionBoole = src.getRow() > dest.getRow();            // if true, source righter than dest
     int xmultiplier;
     int ymultiplier;
     
   if (super.getMyBoard() != null) {                           //if the board is present
    if (super.getMyBoard().isValid(dest)) {               // if the dest is usable
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       
       if ((dest.getRow() - src.getRow() == 0 && dest.getCol() - src.getCol() != 0) || (dest.getCol() - src.getCol() == 0 && dest.getRow() - src.getRow() != 0)) {         //    if either row or col exclusive are non-zero
         if (super.getMyBoard().isEmpty(dest) || super.getMyBoard().getPiece(dest).isWhite() != super.isWhite()) {   // if the dest is good
                   if (xdirectionBoole)
                     xmultiplier = -1;
                   else
                     xmultiplier = 1;
                   if (ydirectionBoole)
                     ymultiplier = -1;
                   else
                     ymultiplier = 1;
         for (int i=1; i < Math.abs(src.getRow() - dest.getRow()); i++) {               // if the rook moves up/down
           if (!super.getMyBoard().isEmpty(new Location(src.getRow() + xmultiplier*i, src.getCol()))) 
              return false;
         }
         
         for (int i=1; i < Math.abs(src.getCol() - dest.getCol()); i++) {               // if the rook moves left/right
           if (!super.getMyBoard().isEmpty(new Location(src.getRow(), src.getCol() + ymultiplier*i))) 
              return false;
         }
           super.getMyBoard().movePiece(src, dest);        // if everything is valid
           moveBoole = true;
           return true;
        }
       }
     }
   }
  }
   return false;
 }
   
   public boolean hasMoved() {
     return moveBoole;
   }
   
   public String toString() {
    if (isWhite())
      return "r";
    else
      return "R";
  }
   
}