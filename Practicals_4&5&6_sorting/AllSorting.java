package lab4_elementary_sorting;
/*
The following file contains all of the sorting algorithms covered in practicals 4, 5, 6
This includes selection sort, insertion sort, bogoSort, mergeSort, enhancedMergeSort, quickSort, enhancedQuickSort
 */
import java.util.Arrays;
import java.util.Scanner;

public class AllSorting {

                        ///////////// Practical 4 //////////////
    /*
    The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element becomes a part of the sorted array.
    This process continues moving unsorted array boundary by one element to the right.
     */
    private static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
            
        }
        
    }

    /*
    In Insertion sort, you compare the key element with the previous elements.
    If the previous elements are greater than the key element, then you move the previous element to the next position.
     */
    private static void insertionSort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            Comparable valueToSort = a[i];
            int j = i;

            while (j > 0 && a[j - 1].compareTo(valueToSort) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = valueToSort;
        }
    }

    /*
    Bogosort simply shuffles a collection randomly until it is sorted.
     */
    private static void bogoSort(Comparable[] arr){
        while(!isSorted(arr)){
            shuffle(arr);
        }
    }


                    //////////// Practical 5 /////////////

    /*
    merges the two halves together
     */
    private static void merge(Comparable[] a, Comparable[] helperArray, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            helperArray[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = helperArray[j++];
            else if (j > hi)
                a[k] = helperArray[i++];
            else if
            (less(helperArray[j], helperArray[i])) a[k] = helperArray[j++];
            else a[k] = helperArray[i++];
        }

    }

    /*
    It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves.
     */
    private static void mergeSort(Comparable[] a, Comparable[] helperArray, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, helperArray, lo, mid);
        mergeSort(a, helperArray, mid + 1, hi);
        merge(a, helperArray, lo, mid, hi);
    }

    private static void enhancedMergeSort(Comparable[] sourceArray, Comparable[] destinationArray, int lo, int hi) {
        // if (hi <= lo) return;
        if (hi <= lo + 8) {//cutoff point for calling insertion sort
            insertionSort(destinationArray);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        enhancedMergeSort(destinationArray, sourceArray, lo, mid);
        enhancedMergeSort(destinationArray, sourceArray, mid+1, hi);

         if (!less(sourceArray[mid+1], sourceArray[mid])) {
            for (int i = lo; i <= hi; i++) destinationArray[i] = sourceArray[i];
            return;
         }



        merge(sourceArray, destinationArray, lo, mid, hi);
    }


    //////////// Practical 6 ////////////

    /*
    It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays,
    according to whether they are less than or greater than the pivot.
     */
    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;
            }

            // check if pointers cross
            if (i >= j) break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private static void enhancedQuickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }


        enhancedQuickSort(a, lo, lt-1);
        enhancedQuickSort(a, gt+1, hi);
    }



    //////// helper methods /////////

    private static boolean isSorted(Comparable[] arr){
        for(int i = 1; i < arr.length; i++){
            if(less(arr[i], arr[i-1])){
                return false;
            }
        }
        return true;
    }

    private static void swap(Object[] a, int i, int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void shuffle(Comparable[] a) {
        for (int i = 1; i < a.length-1; i++) {
            swap(a, i, (int)(Math.random()*i));
        }
    }

    //a < b
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }


    /*
    Generates a random comparable array of given size
     */
    private static Comparable[] randomCompArray(int size){
        Comparable[] arr = new Comparable[size];
        for(int i = 0; i < size; i++){
            arr[i] = (int) (Math.random() * 1000);

            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the size for the array");
        int size = in.nextInt();

        Comparable[] randomArray = randomCompArray(size);

        System.out.println(Arrays.toString(randomArray));

//        selectionSort(randomArray);
//        insertionSort(randomArray);
//        bogoSort(randomArray);
//        mergeSort(randomArray, randomCompArray(randomArray.length), 0,randomArray.length - 1);
//        enhancedMergeSort(randomArray, randomCompArray(randomArray.length), 0,randomArray.length - 1);
//        quickSort(randomArray, 0, randomArray.length - 1);
//        enhancedQuickSort(randomArray, 0, randomArray.length -1);

        System.out.println("The available sorting algorithms are: " +
                "(1) mergeSort" + '\n' +
                "(2) enhancedMergeSort" + '\n' +
                "(3) quickSort" + '\n' +
                "(4) enhancedQuickSort" + '\n' +
                "(5) selectionSort " + '\n' +
                "(6) insertionSort" + '\n' +
                "(7) bogoSort");
        System.out.println("Please choose the sorting algorithm to perform: ");
        Scanner typeOfSort = new Scanner(System.in);
        int choice = typeOfSort.nextInt();
        long startTime = System.nanoTime();

        for (int i = 0; i < 2; i++) {

            switch (choice) {
                case 1:
                    mergeSort(randomArray, randomCompArray(randomArray.length), 0, randomArray.length - 1);
                    break;
                case 2:
                    enhancedMergeSort(randomArray, randomCompArray(randomArray.length), 0, randomArray.length - 1);
                    break;
                case 3:
                    quickSort(randomArray, 0, randomArray.length - 1);
                    break;
                case 4:
                    enhancedQuickSort(randomArray, 0, randomArray.length - 1);
                    break;
                case 5:
                    selectionSort(randomArray);
                    break;
                case 6:
                    insertionSort(randomArray);
                    break;
                case 7:
                    bogoSort(randomArray);
                    break;
            }
        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Estimated time:" + estimatedTime);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(randomArray));

    }
}

