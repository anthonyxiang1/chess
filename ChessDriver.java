//Anthony Xiang
// AP CS Period 9

import java.util.Scanner;

public class ChessDriver {
  public static void main(String[] args) {
    
    Board boa = new Board(true);
    Scanner scan = new Scanner(System.in);
    boolean repeater = true;
    
    System.out.println(boa);
    
    while(true) {  
      try {
    while(repeater) {
      boolean goodmove = false;
      
      System.out.println("White's source");
      Location src = new Location(scan.nextLine());
      System.out.println("White's destination");
      Location dest = new Location(scan.nextLine());
      
      if (boa.getPiece(src).isWhite() && !boa.isEmpty(src) && boa.isValid(src))
        goodmove = boa.getPiece(src).move(dest);
      
      
      if (!goodmove) {
        System.out.println("This move is not valid");
        repeater = true;
      }
      else {
      System.out.println(boa);
      repeater = false;
      }
      
    }
    // for black move
    while(!repeater) {
      boolean goodmove = false;
      
      System.out.println("Black's source");
      Location src2 = new Location(scan.nextLine());
      System.out.println("Black's destination");
      Location dest2 = new Location(scan.nextLine());
      
      if (!boa.getPiece(src2).isWhite() && !boa.isEmpty(src2) && boa.isValid(src2))
         goodmove = boa.getPiece(src2).move(dest2);

      if (!goodmove) {
        System.out.println("This move is not valid");
        repeater = false;
      }
      else {
      System.out.println(boa);
      repeater = true;
      }
      
    }
      }
      catch (NullPointerException exception) {
       System.out.println("This move is not valid");
      }
    }
  }
}