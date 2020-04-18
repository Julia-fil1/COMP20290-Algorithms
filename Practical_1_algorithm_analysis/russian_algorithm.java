package lab1_algorithm_analysis;
import javax.sound.midi.Soundbank;
import java.lang.System;
import java.util.Scanner;

public class russian_algorithm {
 public static int rpa(int x, int y){
  int total = 0;
  while (x != 0) {
   if (x % 2 == 0) {

   } else if (x % 2 == 1) {
    total += y;
   }

   x = x / 2;
   y = y * 2;
  }

  return total;
 }

//    public static long longRPA(long x, long y){
//        long total = 0;
//        while (x != 0) {
//            if (x % 2 == 0) {
//
//            } else if (x % 2 == 1) {
//                total += y;
//            }
//
//            x = x / 2;
//            y = y * 2;
//        }
//
//        return total;
//    }

 public static void main(String[] args) {
  // write your code here
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the first number: ");
//        int x = in.nextInt();
//        System.out.println("Enter the second number: ");
//        int y = in.nextInt();
//
  int result = rpa(4383, 8283);

//        long x = in.nextLong();
//        long y = in.nextLong();
//
//        long result = longRPA(x, y);

  long startTime = System.nanoTime();

  long endTime = System.nanoTime();
  long elapsedTime = endTime - startTime;
  //System.out.println( x + " x " + y + ", " + elapsedTime + ", " + result);
  System.out.println(elapsedTime + ", " + result);

 }

}