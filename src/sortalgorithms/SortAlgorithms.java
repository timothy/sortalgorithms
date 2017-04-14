/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

//import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * This will run each method in the Evaluator and give benchmarks to each
 * sorting algorithm performed.
 *
 * @author Timothy Bradford
 */
public class SortAlgorithms {

    /**
     * This formates output for algorithm times
     *
     * @param title - Introduction of information to be displayed
     * @param stop the time when the algorithm is completed
     * @param start the time when the algorithm started.
     */
    public static void timeOutPut(String title, long stop, long start) {
        long totalMil = (stop - start);
        System.out.println(title + " - In Nano Seconds:" + totalMil + " - In MilliSeconds:" + TimeUnit.NANOSECONDS.toMillis(totalMil) + " - In Seconds:" + TimeUnit.NANOSECONDS.toSeconds(totalMil));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Evaluator eval = new Evaluator();

        //for consistancy I am making all random arrays the same.
        int[] randomArray = eval.genRandom();

        int[] selectDS = eval.genDescendingSequential();
        int[] selectR = new int[eval.arrayReturnSize];
        int[] selectS = eval.genSequential();

        int[] insertDS = eval.genDescendingSequential();
        int[] insertR = new int[eval.arrayReturnSize];
        int[] insertS = eval.genSequential();

        int[] mergeDS = eval.genDescendingSequential();
        int[] mergeR = new int[eval.arrayReturnSize];
        int[] mergeS = eval.genSequential();

        System.arraycopy(randomArray, 0, selectR, 0, mergeR.length);
        System.arraycopy(randomArray, 0, insertR, 0, insertR.length);
        System.arraycopy(randomArray, 0, mergeR, 0, mergeR.length);

        /**
         * Merge Sort - sort and time using all three arrays
         */
        long mergeStartTimeRand = System.nanoTime();
        eval.mergeSortBradford(mergeR);//Random Array
        long mergeEndTimeRand = System.nanoTime();

        long mergeStartTimeSeq = System.nanoTime();
        eval.mergeSortBradford(mergeS);//Sequential Array
        long mergeEndTimeSeq = System.nanoTime();

        long mergeStartTimeDesc = System.nanoTime();
        eval.mergeSortBradford(mergeDS);// Descending Sequential Array
        long mergeEndTimeDesc = System.nanoTime();

        /**
         * Select Sort - sort and time using all three arrays
         */
        long selectionStartTimeRand = System.nanoTime();
        eval.selectionSortBradford(selectR);//Random Array
        long selectionEndTimeRand = System.nanoTime();

        long selectionStartTimeSeq = System.nanoTime();
        eval.selectionSortBradford(selectS);//Sequential Array
        long selectionEndTimeSeq = System.nanoTime();

        long selectionStartTimeDesc = System.nanoTime();
        eval.selectionSortBradford(selectDS);// Descending Sequential Array
        long selectionEndTimeDesc = System.nanoTime();

        /**
         * Insert Sort - sort and time using all three arrays
         */
        long insertionStartTimeRand = System.nanoTime();
        eval.insertionSortBradford(insertR);//Random Array
        long insertionEndTimeRand = System.nanoTime();
        //System.out.println(Arrays.toString(insertR));//just making sure it is in order...

        long insertionStartTimeSeq = System.nanoTime();
        eval.insertionSortBradford(insertS);//Sequential Array
        long insertionEndTimeSeq = System.nanoTime();

        long insertionStartTimeDesc = System.nanoTime();
        eval.insertionSortBradford(insertDS);// Descending Sequential Array
        long insertionEndTimeDesc = System.nanoTime();
//        System.out.println(Arrays.toString(insertDS));//just making sure it is in order...

        /**
         * Console output
         */
        System.out.println("**********************************Selection*Sort*********************************************");
        timeOutPut("Total Time for Random Array:", selectionEndTimeRand, selectionStartTimeRand);
        timeOutPut("Total Time for Sequential Array:", selectionEndTimeSeq, selectionStartTimeSeq);
        timeOutPut("Total Time for Descending Sequential Array:", selectionEndTimeDesc, selectionStartTimeDesc);
        System.out.println("*****************************************************************************************\n");

        System.out.println("**********************************Insertion*Sort*********************************************");
        timeOutPut("Total Time for Random Array:", insertionEndTimeRand, insertionStartTimeRand);
        timeOutPut("Total Time for Sequential Array:", insertionEndTimeSeq, insertionStartTimeSeq);
        timeOutPut("Total Time for Descending Sequential Array:", insertionEndTimeDesc, insertionStartTimeDesc);
        System.out.println("*****************************************************************************************\n");

        System.out.println("************************************Merge*Sort*********************************************");
        timeOutPut("Total Time for Random Array:", mergeEndTimeRand, mergeStartTimeRand);
        timeOutPut("Total Time for Sequential Array:", mergeEndTimeSeq, mergeStartTimeSeq);
        timeOutPut("Total Time for Descending Sequential Array:", mergeEndTimeDesc, mergeStartTimeDesc);
        System.out.println("*****************************************************************************************");
    }

}
