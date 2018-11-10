//Anthony Xiang
// AP CS Period 9

public class Board {
  
  private boolean reset;
  private Piece[][] arr;
  
  public Board(boolean reset) {
    arr = new Piece[8][8];
    
    if (reset == true) 
      reset();
  }
  
    public Piece getPiece(Location loc) {
      
    return arr[loc.getRow()][loc.getCol()];
  }
  
  public Piece placePiece(Piece p, Location destination) {
    Piece previous = getPiece(destination);                      // stores the previous space there, null if there is none

    arr[destination.getRow()][destination.getCol()] = p;
    
    return previous;
  }
  
  public boolean isEmpty(Location loc) {
    return (getPiece(loc) == null);
  }
  
    public void reset() {
      for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        Location resetters = new Location(i,j);
      }
      }
 //Knights
      Knight kni = new Knight(false, this, new Location(0,1));
      Knight kni1 = new Knight(false, this, new Location(0,6));
      Knight kni2 = new Knight(true, this, new Location(7,6));
      Knight kni3 = new Knight(true, this, new Location(7,1));
 //Rooks
      Rook roo = new Rook(false, this, new Location(0,0));
      Rook roo1 = new Rook(false, this, new Location(0,7));
      Rook roo2 = new Rook(true, this, new Location(7,0));
      Rook roo3 = new Rook(true, this, new Location(7,7));
 //Bishops
      Bishop bis = new Bishop(false, this, new Location(0,2));
      Bishop bis1 = new Bishop(false, this, new Location(0,5));
      Bishop bis2 = new Bishop(true, this, new Location(7,5));
      Bishop bis3 = new Bishop(true, this, new Location(7,2));
 //Queens
      Queen que = new Queen(false, this, new Location(0,3));
      Queen que1 = new Queen(true, this, new Location(7,3));
 //King
      King kin = new King(false, this, new Location(0,4));
      King kin1 = new King(true, this, new Location(7,4));
 //Pawn
         for (int i = 0; i <=7; i++) {
          arr[1][i] = new Pawn(false, this, new Location(1,i));
         for (int j = 0; j <=7; j++) {
          arr[6][j] = new Pawn(true, this, new Location(6,j));
  }
         }
    }
    
    public Location locationOf(Piece p) {
      for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
         if (p == arr[i][j])
           return new Location (i,j);
       }
      }
      return null;
    }
    
    public Piece movePiece(Location src, Location destination) {
      
     Piece previous = getPiece(destination);
      
      if (arr[src.getRow()][src.getCol()] == null)
        throw new IllegalArgumentException("movePiece error");
      else {
        if (arr[destination.getRow()][destination.getCol()]  == null) {
         arr[destination.getRow()][destination.getCol()] = arr[src.getRow()][src.getCol()];
         arr[src.getRow()][src.getCol()] = null;
         return null;
        }
        else {
         arr[destination.getRow()][destination.getCol()] = arr[src.getRow()][src.getCol()];
        arr[src.getRow()][src.getCol()]  = null;
         return previous;
        }
      }
    }
    
    public Piece removePiece(Location destination) {
      Piece previous = getPiece(destination);
      
      if (getPiece(destination) == null)
            return null;
      else
         return previous;
          }
    
    public boolean isValid(Location destination) {
      if (destination.getRow() < 8 && destination.getRow() > -1 && destination.getCol() < 8 && destination.getCol() > -1)
        return true;
      else
        return false;
    }
  
  public String toString() {
    String arrString = "";
    
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
       
       if (arr[i][j] != null)
         arrString += arr[i][j].toString() + "\t";           // calls the toString of that piece
       else
        arrString += "-" + "\t";
     }
        arrString += "\n";
  }
   return arrString;
 }
}
    