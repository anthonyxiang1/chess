//Anthony Xiang
// AP CS Period 9

public class Location {
  
  private int row;
  private int col;
  private String str;
  
  public Location (int x, int y){
    row = x;
    col = y;
  }
  
  public Location (String s) {
   str = s;
   
   if (str.length() != 2) 
        throw new IllegalArgumentException();
     else {   
         if (Integer.parseInt("" + str.charAt(1)) < 0 || Integer.parseInt("" + str.charAt(1)) > 8)
            throw new IllegalArgumentException();
         else
             row = 8 - Integer.parseInt("" + str.charAt(1));       // converts the numbers to matrix rows
       
      if (str.charAt(0) == 'a' || str.charAt(0) == 'A')              // converts all of the letters to a column
       col = 0;
      else if (str.charAt(0) == 'b' || str.charAt(0) == 'B') 
       col = 1;
      else if (str.charAt(0) == 'c' || str.charAt(0) == 'C') 
       col = 2;
      else if (str.charAt(0) == 'd' || str.charAt(0) == 'D') 
       col = 3;
      else if (str.charAt(0) == 'e' || str.charAt(0) == 'E') 
       col = 4;
      else if (str.charAt(0) == 'f' || str.charAt(0) == 'F') 
       col = 5;
      else if (str.charAt(0) == 'g' || str.charAt(0) == 'G') 
       col = 6;
      else if (str.charAt(0) == 'h' || str.charAt(0) == 'H') 
       col = 7;
      else
       throw new IllegalArgumentException();
   }
  }
  
  public int getRow() {
    return row;
  }
  
  public void setRow (int value) {
    row = value;
  }
  
  public int getCol() {
    return col;
  }
  
  public void setCol(int value) {
    col = value;
  }
  
  public String toString() { 
    return("Row is: " + row + " Col is: " + col);
  }
  
  public boolean equals(Location loc) {
   return ((loc.getRow() == row && loc.getCol() == col));
 }
  
}