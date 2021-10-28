package com.company;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] universe = {1, 2, 3, 4, 5, 6, 7, 8};
        SetOperations oper = new SetOperations(universe);
        System.out.println("Input first array");
        int[] arr1 = scanner(universe);
        System.out.println("Input second array");
        int[] arr2 = scanner(universe);
        System.out.println("Перетин");
        PrintArray(oper.intersection(arr1, arr2));
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
    static void MatrixToString(Integer[][] input) {
        for (Integer[] el : input) {
            System.out.print(Arrays.toString(el) + ", ");
        }

    }

    //FOR everything else
    static void PrintArray(int[] input) {
        System.out.println(Arrays.toString(input));
    }
}


// 4 6 7