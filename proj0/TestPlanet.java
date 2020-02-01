import java.math.*;
/**
*   Test the Planet Class
*/
public class TestPlanet{
  /**
  *   Test the Planet
  */
  public static void main(String[] args){
    checkPlanet();
  }
  /**
  *   Check whether or not the two doubles are equal and print the result
  *
  *   @param expected   Expected double
  *   @param actual     actual received doble
  *   @param label      test label
  *   @param eps        Tolerance for the doubles comparison
  */
  private static void checkEquals(double expected, double actual, String label, double eps){
    if (Math.abs(actual - expected) <= eps * Math.max(expected, actual)){
      System.out.println("PASS " + label + ": expected " + expected + " and you gave " + actual);
    } else {
      System.out.println("FAIL " + label + ": expected " + expected + " and you gave " + actual);
    }
  }

  /**
   *  Checks the Planet class to make sure it works.
   */
   private static void checkPlanet(){
     System.out.println("Checking Planet ");
     Planet Sun = new Planet(1e12,2e11,0,0,2e30,"Sun.jpg");
     Planet Saturn = new Planet(2.3e12,9.5e11,0,0,6e26,"Saturn.jpg");
     checkEquals(3.6e22,Sun.calcForceExertedBy(Saturn),"Pair force",0.1);
     checkEquals(3.6e22,Saturn.calcForceExertedBy(Sun),"Pair force",0.1);

   }
}
