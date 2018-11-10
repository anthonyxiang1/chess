//Anthony Xiang
// AP CS Period 9

public class King extends Piece {
  
  private boolean moveBoole;
  
  public King (boolean boole, Board board) {
    super(boole, board);
    moveBoole = false;
  }
  
  public King (boolean boole, Board board, Location loc) {
    super(boole, board, loc);
    moveBoole = false;
  }
  
   public boolean move(Location dest) {
     
   if (super.getMyBoard() == null)
     return false;
   
   Location src = super.getMyBoard().locationOf(this);
   
   double distance = Math.sqrt(Math.pow((src.getRow() - dest.getRow()), 2) + Math.pow((src.getCol() - dest.getCol()), 2));
   
   if (super.getMyBoard().isValid(dest)) {                          // if the dest is valid
     if (src != null && super.getMyBoard().isValid(src)) {       // if the src is usable
       if (distance >= 1 && distance < 1.5) {                     //    if distance of rows and cols is not equal to either 1 or sqrt(2)
       
        if (!super.getMyBoard().isEmpty(dest)) {               // if the dest is not empty
          
          if (super.getMyBoard().getPiece(dest).isWhite() == super.isWhite()) 
                      return false;
          
             else {
                    super.getMyBoard().movePiece(src, dest);
                    moveBoole = true;
                    return true;
             }
           }
             super.getMyBoard().movePiece(src, dest);        // if the dest is empty
             moveBoole = true;
             return true;
     }
       
       else if (!moveBoole && Math.abs(src.getCol() - dest.getCol()) == 2 && src.getRow() == dest.getRow()) {           // signals a castle

         if (src.getCol() > dest.getCol())   {          // kings castling left
           Location rooksrc = new Location(dest.getRow(), dest.getCol()-2);
            Piece p = getMyBoard().getPiece(rooksrc);
             if (p instanceof Rook) {
               Rook rookInstance = (Rook) p;
               if (!rookInstance.hasMoved()) {
                 for (int i=1; i < Math.abs(src.getCol() - dest.getCol()); i++) {               
                    if (!super.getMyBoard().isEmpty(new Location(src.getRow(), src.getCol() - i))) 
                     return false;
                 }
             }
               super.getMyBoard().getPiece(rooksrc).getMyBoard().movePiece(rooksrc, new Location(dest.getRow(), dest.getCol()+1));
               super.getMyBoard().movePiece(src, dest);
               moveBoole = true;
               return true;
         }
         }
         else if (src.getCol() < dest.getCol())   {          // kings castling right
           Location rooksrc = new Location(dest.getRow(), dest.getCol()+1);
            Piece p2 = getMyBoard().getPiece(rooksrc);
             if (p2 instanceof Rook) {
               Rook rookInstance = (Rook) p2;
               if (!rookInstance.hasMoved()) {
                 for (int i=1; i < Math.abs(src.getCol() - dest.getCol()); i++) {               
                    if (!super.getMyBoard().isEmpty(new Location(src.getRow(), src.getCol() + i))) 
                     return false;
                 }
                 super.getMyBoard().getPiece(rooksrc).getMyBoard().movePiece(rooksrc, new Location(dest.getRow(), dest.getCol()-1));
                 super.getMyBoard().movePiece(src, dest);
                 moveBoole = true;
                 return true;
             }
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
      return "k";
    else
      return "K";
  }
   
}