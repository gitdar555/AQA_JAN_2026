package org.prog.session2;

public class Homework2 {

    public static void main(String[] args) {

        int[] myArrayToSort = {4, 1, 8, 5, 8, 0, 12, 9};
        boolean condition = true;

        while (condition) {
            condition = false;

            for (int i = 0; i < myArrayToSort.length - 1; i++) {
                if (myArrayToSort[i] > myArrayToSort[i + 1]) {
                    int temp = myArrayToSort[i];
                    myArrayToSort[i] = myArrayToSort[i + 1];
                    myArrayToSort[i + 1] = temp;

                    condition = true;
                }
            }
        }

        for (int num : myArrayToSort) {
            System.out.print(num + " ");
        }
    }
}
