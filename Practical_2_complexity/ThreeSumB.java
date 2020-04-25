package lab2_complexity; /******************************************************************************
 *  Compilation:  javac ThreeSumB.java
 *  Execution:    java ThreeSumB input.txt
 *
 *  Reads n integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *     - doesn't handle case when input has duplicates
 *     
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 ******************************************************************************/

import java.io.File;
import java.util.Arrays;
import java.lang.*;


public class ThreeSumB {

    // Do not instantiate.
    private ThreeSumB() { }

    // returns true if the sorted array a[] contains any duplicated integers
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }

  
    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    } 

    /**
     * Reads in a sequence of distinct integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  {
        int res;

        System.out.println("Input: 1Kints.txt");
        File file = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\1Kints.txt");
        In in = new In(file);
        int[] a = in.readAllInts();
        long startTime = System.currentTimeMillis();
        res = count(a);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTime);
        System.out.println();

        System.out.println("Input: 2Kints.txt");
        File file2 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\2Kints.txt");
        In in2 = new In(file2);
        int[] b = in2.readAllInts();
        long startTimeTwo = System.currentTimeMillis();
        res  = count(b);
        long estimatedTimeTwo = System.currentTimeMillis() - startTimeTwo;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeTwo);
        System.out.println();

        System.out.println("Input: 4Kints.txt");
        File file3 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\4Kints.txt");
        In in3 = new In(file3);
        int[] c = in3.readAllInts();
        long startTimeThree = System.currentTimeMillis();
        res = count(c);
        long estimatedTimeThree = System.currentTimeMillis() - startTimeThree;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeThree);
        System.out.println();

        System.out.println("Input: 8ints.txt");
        File file4 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\8ints.txt");
        In in4 = new In(file4);
        int[] d = in4.readAllInts();
        long startTimeFour = System.currentTimeMillis();
        res = count(d);
        long estimatedTimeFour = System.currentTimeMillis() - startTimeFour;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeFour);
        System.out.println();

        System.out.println("Input: 8Kints.txt");
        File file5 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\8Kints.txt");
        In in5 = new In(file5);
        int[] e = in5.readAllInts();
        long startTimeFive = System.currentTimeMillis();
        res = count(e);
        long estimatedTimeFive = System.currentTimeMillis() - startTimeFive;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeFive);
        System.out.println();

        System.out.println("Input: 16Kints.txt");
        File file6 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\16Kints.txt");
        In in6 = new In(file6);
        int[] f = in6.readAllInts();
        long startTimeSix = System.currentTimeMillis();
        res = count(f);
        long estimatedTimeSix = System.currentTimeMillis() - startTimeSix;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeSix);
        System.out.println();

        System.out.println("Input: 32Kints.txt");
        File file7 = new File("C:\\Users\\Julia\\OneDrive\\Desktop\\Algorithms_Repo\\src\\lab2_complexity\\32Kints.txt");
        In in7 = new In(file7);
        int[] g = in7.readAllInts();
        long startTimeSeven = System.currentTimeMillis();
        res = count(g);
        long estimatedTimeSeven = System.currentTimeMillis() - startTimeSeven;
        System.out.println("Result: " + res);
        System.out.println("Time taken: " + estimatedTimeSeven);
        System.out.println();
    } 
} 

