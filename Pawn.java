//Anthony Xiang
// AP CS Period 9

public class Pawn extends Piece {
  
  private boolean moveBoole;
  
  public Pawn (boolean boole, Board board) {
    super(boole, board);
    moveBoole = false;
  }
  
  public Pawn (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
    moveBoole = false;
  }
  
   public boolean move(Location dest) {
     
   if (super.getMyBoard() == null)
     return false;
   
   Location src = super.getMyBoard().locationOf(this);
   double coldiff = Math.abs((src.getCol() - dest.getCol()));
   
   
   if (super.getMyBoard().isValid(dest)) {                          // if the dest is valid
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       if (src.getCol() == dest.getCol() && super.getMyBoard().isEmpty(dest)) {                           // when the pawn moves straight and the destination is open
         
          if (super.isWhite() && dest.getRow() == super.myLocation().getRow() - 2 && super.getMyBoard().isEmpty(new Location (dest.getRow()+1, dest.getCol())) && super.myLocation().getRow() == 6) {      //  move 2 white
           super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
         }
         else if (!super.isWhite() && dest.getRow() == super.myLocation().getRow() + 2 && super.getMyBoard().isEmpty(new Location (dest.getRow()-1, dest.getCol())) && super.myLocation().getRow() == 1) {  //  move 2 black
           super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
         }
          else if (super.isWhite() && dest.getRow() == super.myLocation().getRow() - 1) {             // normal move 1 white
            super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
         }
           else if (!super.isWhite() && dest.getRow() == super.myLocation().getRow() + 1) {            // normal move 1 black
            super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
         }
           else 
                    return false;
           
           
                  }
       if (!super.getMyBoard().isEmpty(dest) && super.getMyBoard().getPiece(dest).isWhite() != super.isWhite()) {
         if (super.isWhite() && coldiff == 1 && dest.getRow() == super.myLocation().getRow() - 1) {                        // capture white
           super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
         }
         else if (!super.isWhite() && coldiff == 1 && dest.getRow() == super.myLocation().getRow() + 1) {                        // capture white
           super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
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
      return "p";
    else
      return "P";
  }
   
}