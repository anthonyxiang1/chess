//Anthony Xiang
// AP CS Period 9

public class Knight extends Piece {
  
  public Knight (boolean boole, Board board) {
    super(boole, board);
  }
  
  public Knight (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
  }
  
   public boolean move(Location dest) {
     
   if (super.getMyBoard() == null)
     return false;
   
   Location src = super.getMyBoard().locationOf(this);
   
   double distance = Math.sqrt(Math.pow((src.getRow() - dest.getRow()), 2) + Math.pow((src.getCol() - dest.getCol()), 2));
   
   if (super.getMyBoard().isValid(dest)) {                          // if the dest is valid
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       if (distance < 2.237 && distance > 2.236) {                     //    if distance of rows and cols is not equal to sqrt5
       
        if (!super.getMyBoard().isEmpty(dest)) {               // if the dest is not empty
          
          if (super.getMyBoard().getPiece(dest).isWhite() == super.isWhite()) 
                      return false;
          
             else {
                    super.getMyBoard().movePiece(src, dest);
                   return true;
             }
           }
             super.getMyBoard().movePiece(src, dest);        // if the dest is empty
             return true;
     }
   }
  }
   
   return false;
 }
   
   public String toString() {
    if (isWhite())
      return "n";
    else
      return "N";
  }
   
}