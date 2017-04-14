/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

import java.security.SecureRandom;

/**
 * This class contains multiple versions of sorting algorithms. The purpose of
 * this is to measure the effectiveness of each algorithm.
 *
 * @author Timothy Bradford
 */
public class Evaluator {

    /**
     * this is the size each return array will be
     */
    public int arrayReturnSize = 100000;

    /**
     * a method that sorts using the Selection sort algorithm
     *
     * @param data the array to be sorted
     */
    public void selectionSortBradford(int[] data) {
        int smallest;
        for (int i = 0; i < data.length - 1; i++) {
            smallest = i;

            for (int index = i + 1; index < data.length - 1; index++) {
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }
            swap(data, i, smallest);
        }
    }

    /**
     * a method that sorts using the Insertion sort algorithm
     *
     * @param data the array to be sorted
     */
    public void insertionSortBradford(int[] data) {
        int insert;
        int moveItem;

        for (int next = 1; next < data.length - 1; next++) {
            insert = data[next];
            moveItem = next;
            while (moveItem > 0 && data[moveItem - 1] > insert) {
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }
            data[moveItem] = insert;
        }

    }

    /**
     * a method that sorts using the Merge sort algorithm
     *
     * @param data the array to be sorted
     */
    public void mergeSortBradford(int[] data) {
        sortArrayBradford(data, 0, data.length - 1);
    }

    /**
     * This is the recursive Merge sort algorithm
     *
     * @param data the array to be sorted
     * @param low low end of array
     * @param high high end of array
     */
    public void sortArrayBradford(int[] data, int low, int high) {

        if ((high - low) >= 1) {
            int middle1 = (low + high) / 2;
            int middle2 = middle1 + 1;

            //Split array in half sort each half
            sortArrayBradford(data, low, middle1);
            sortArrayBradford(data, middle2, high);

            // merge
            mergeBradford(data, low, middle1, middle2, high);
        }

    }

    /**
     * will merge the two arrays from the Merge sort method
     *
     * @param data the array to be merged
     * @param left left side of array
     * @param middle1 middle for array 1
     * @param middle2 middle for array 2
     * @param right right side of array
     */
    public void mergeBradford(int[] data, int left, int middle1, int middle2, int right) {
        int leftIndex = left;// index into left subarray 
        int rightIndex = middle2;// index into right subarray 
        int combinedIndex = left;// index into temporary working array 
        int[] combined = new int[data.length];// working array

        // merge arrays until reaching end of either 
        while (leftIndex <= middle1 && rightIndex <= right) {
            // place smaller of two current elements into result 
            // and move to next space in arrays 
            if (data[leftIndex] <= data[rightIndex]) {
                combined[combinedIndex++] = data[leftIndex++];
            } else {
                combined[combinedIndex++] = data[rightIndex++];
            }
        }

        // if left array is empty 
        if (leftIndex == middle2) // copy in rest of right array 
        {
            while (rightIndex <= right) {
                combined[combinedIndex++] = data[rightIndex++];
            }
        } else// right array is empty  // copy in rest of left array 
        {
            while (leftIndex <= middle1) {
                combined[combinedIndex++] = data[leftIndex++];
            }
        }
        // copy values back into original array 
        for (int i = left; i <= right; i++) {
            data[i] = combined[i];
        }
    }

    /**
     * this will swap positions in an array
     *
     * @param data the array
     * @param first the first position to be swapped
     * @param second the second position to be swapped
     */
    public void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    /**
     * @return an array with 100,000 int values in sequential order, starting
     * with 1 and ending with 100,000.
     */
    public int[] genSequential() {
        int[] data = new int[this.arrayReturnSize];// create array

        //populate array
        for (int i = 0; i < arrayReturnSize; i++) {
            data[i] = i + 1;
        }
        return data;
    }

    /**
     * @return an array with 100,000 random int values.
     */
    public int[] genRandom() {
        SecureRandom generator = new SecureRandom();
        int[] data = new int[this.arrayReturnSize];// create array

        //populate array
        for (int i = 0; i < this.arrayReturnSize; i++) {
            data[i] = 1 + generator.nextInt(this.arrayReturnSize - 1);
        }

        return data;
    }

    /**
     * @return an array with 100,000 int values in descending sequential order,
     * starting with 100,000 and ending with 1.
     */
    public int[] genDescendingSequential() {
        int[] data = new int[arrayReturnSize];// create array
        //populate array
        for (int i = 0; i < arrayReturnSize; i++) {
            data[i] = arrayReturnSize - i;
        }
        return data;
    }

}
