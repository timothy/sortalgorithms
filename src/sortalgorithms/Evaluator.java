/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

/**
 *
 * @author ^_^
 */
public class Evaluator {

    public static void selectionSortBradford(int[] data) {
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

    public static int insertionSortBradford() {
        return -1;
    }

    public static int mergeSortBradford() {
        return -1;
    }

    public static void swap(int[] data, int first, int second) {
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

}
