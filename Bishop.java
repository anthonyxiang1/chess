//Anthony Xiang
// AP CS Period 9

public class Bishop extends Piece {
  
  public Bishop (boolean boole, Board board) {
    super(boole, board);
  }
  
  public Bishop (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
  }
  
   public boolean move(Location dest) {
     
     Location src = super.getMyBoard().locationOf(this);
     boolean ydirectionBoole = src.getCol() > dest.getCol();            // if true, source righter than dest
     boolean xdirectionBoole = src.getRow() > dest.getRow();            // if true, source lower than dest
     int xmultiplier;
     int ymultiplier;
     
   if (super.getMyBoard() != null) {                           //if the board is present
    if (super.getMyBoard().isValid(dest)) {               // if the dest is usable
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       
       if ((Math.abs(dest.getRow() - src.getRow()) == Math.abs(dest.getCol() - src.getCol()))) {         //    if the distance traveled by row = distance traveled by col
         if (super.getMyBoard().isEmpty(dest) || super.getMyBoard().getPiece(dest).isWhite() != super.isWhite()) {   // if the dest is good
                   if (xdirectionBoole)
                     xmultiplier = -1;
                   else
                     xmultiplier = 1;
                   if (ydirectionBoole)
                     ymultiplier = -1;
                   else
                     ymultiplier = 1;
         for (int i=1; i < Math.abs(src.getRow() - dest.getRow()); i++) {               // check spaces when the bishop moves diagonally
           if (!super.getMyBoard().isEmpty(new Location(src.getRow() + xmultiplier*i, src.getCol() + ymultiplier*i))) 
              return false;
           
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
      return "b";
    else
      return "B";
  }
   
}