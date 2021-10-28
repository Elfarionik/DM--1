package com.company;

import java.util.Arrays;

public class SetUtils {
    public static void isSet(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    throw new NotSetException();
            }
        }
    }

    public static void inUniverse(int[] set, int[] universe) {

        for (int ints : set) {
            if (!Arrays.toString(universe).contains(String.valueOf(ints)))
                throw new SetOutOfBoundsUniverse();
        }
    }
}
