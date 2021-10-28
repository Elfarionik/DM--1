package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] universe = {1, 2, 3, 4, 5, 6, 7, 8};
        SetOperations oper = new SetOperations(universe);
        System.out.println("Input first array");
        int[] arr1 = scanner(universe);
        System.out.println("Input second array");
        int[] arr2 = scanner(universe);
        System.out.println("множина 1 у виг. бітового рядка");
        PrintArray(oper.toBit(arr1));
        System.out.println("множина 2 у виг. бітового рядка");
        PrintArray(oper.toBit(arr2));
        System.out.println("сим  бітова різниця");
        PrintArray(oper.symmetricalDifferenceBit(arr1, arr2));
        System.out.println("бітова різниця");
        PrintArray(oper.symmetricalDifference(arr1, arr2));
        System.out.println("сим  бітова різниця у вигляді масиву");
        PrintArray(oper.toArray(oper.symmetricalDifferenceBit(arr1, arr2)));
    }

    static int[] scanner(int[] universe) {
        int[] res;
        Scanner scanner = new Scanner(System.in);
        res = StringToIntArr(scanner.nextLine());
        SetUtils.isSet(res);
        SetUtils.inUniverse(res, universe);
        return res;

    }

    static int[] StringToIntArr(String strSet) {
        String[] strSetArr = strSet.split(" ");
        int[] userSet = new int[strSetArr.length];
        for (int i = 0; i < userSet.length; i++) {
            userSet[i] = Integer.parseInt(strSetArr[i]);
        }
        return userSet;
    }

    //FOR decardMultiply
    static void MatrixToString(int[][] input) {
        for (int[] el : input) {
            System.out.print(Arrays.toString(el) + ", ");
        }

    }

    //FOR everything else
    static void PrintArray(int[] input) {
        System.out.println(Arrays.toString(input));
    }
}


// 4 6 7