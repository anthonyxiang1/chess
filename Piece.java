//Anthony Xiang
// AP CS Period 9

abstract public class Piece {
  
  private boolean white;
  private Board myBoard;
  
  public Piece(boolean boole, Board board) {
    white = boole;
    myBoard = board;
  }
  
  public Piece(boolean boole, Board board, Location loc) {
    white = boole;
    myBoard = board;
      
    board.placePiece(this, loc);
  }
  
    public boolean isWhite() {
    return white;
  }
  
    public Board getMyBoard() {
    return myBoard;
  }

    public abstract boolean move(Location loc);
      
    public Location myLocation() {
      return myBoard.locationOf(this);
    }
  
}
    