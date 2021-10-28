package com.company;

import java.util.*;

public class SetOperations extends SetOutOfBoundsUniverse {

    public int[] getUniverse() {
        return universe;
    }

    private final int[] universe;

    public SetOperations(int[] universe) {
        this.universe = universe;
    }


    //Декардовий добуток
    public int[][] decardMultiply(int[] firstSet, int[] secondSet) {

        int[][] c = new int[firstSet.length * secondSet.length][2];
        int z = 0;
        for (int k : firstSet) {
            for (int i : secondSet) {
                c[z][0] = k;
                c[z][1] = i;
                z++;
            }
        }
        return c;
    }

    //Перетин
    public int[] intersection(int[] firstSet, int[] secondSet) {

        List<Integer> rest = new ArrayList<>();
        for (int el1 : firstSet) {
            for (int el2 : secondSet) {
                if (el1 == el2) {
                    rest.add(el1);
                }
            }
        }
        return ListToInt(rest);
    }

    //Доповнення
    public int[] compliment(int[] firstSet) {

        List<Integer> res = new ArrayList<>();
        for (int el : getUniverse())
            res.add(el);

        for (Integer e : firstSet)
            res.remove(e);

        return ListToInt(res);

    }

    //Об'єднання
    public int[] union(int[] firstSet, int[] secondSet) {
        List<Integer> rest = new ArrayList<>();
        boolean f = true;
        for (int k : firstSet) {
            f = true;
            for (int i : secondSet) {
                if (k == i) {
                    f = false;
                    break;
                }
            }
            if (f) rest.add(k);
        }
        for (int i : secondSet) rest.add(i);
        return ListToInt(rest);
    }

    //Додатковиі методи перевірки


    //Симетрична різниця
    public int[] symmetricalDifference(int[] firstSet, int[] secondSet) {
        return union(intersection(firstSet, compliment(secondSet)), intersection(compliment(firstSet), secondSet));
    }

    //Різниця
    public int[] difference(int[] firstSet, int[] secondSet) {
        return intersection(firstSet, compliment(secondSet));
    }


    //UTILS
    private int[] ListToInt(List<Integer> rest) {
        Integer[] res = rest.toArray(new Integer[0]);
        int[] result = new int[res.length];
        for (int i = 0; i < res.length; ++i) {
            result[i] = res[i];
        }
        return result;
    }

    private int[] IntegerToInt(Integer[] res) {
        int[] result = new int[res.length];
        for (int i = 0; i < res.length; ++i) {
            result[i] = res[i];
        }
        return result;
    }

    //Перевірка на рівність множин
    public boolean equals(int[] firstSet, int[] secondSet) {

        if (firstSet.length != secondSet.length) return false;

        for (int el1 : firstSet) {
            boolean has = false;
            for (int el2 : secondSet) {
                if (el1 == el2) {
                    has = true;
                    break;
                }
            }
            if (!has) return has;
        }
        return true;
    }

    //Перевірка на підмножину
    public boolean isSubset(int[] firstSet, int[] secondSet) {

        for (int el1 : secondSet) {
            boolean has = false;
            for (int el2 : firstSet) {
                if (el2 == el1) {
                    has = true;
                    break;
                }
            }
            /// 1 2 3 4
            /// 1 2 3
            if (!has) return has;

        }
        return true;
    }

    //З массиву у біт
    public int[] toBit(int[] input) {
        int[] res = new int[universe.length];
        for (int i = 0; i < universe.length; i++) {
            res[i] = 0;
        }
        for (int el : input) {
            res[res.length - el] = 1;
        }
        return res;
    }

    public int[] toArray(int[] input) {
        // 1 0 1 0 1 1 1
        int len = 0;
        for (int j : input) if (j == 1) len++;
        int[] res = new int[len];
        int z = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                res[z] = input.length - i;
                z++;
            }
        }
        return res;
    }
    //Бітове перетинання
    public int[] unionBit(int[] firstSet, int[] secondSet) {
        int[] res = new int[universe.length];
        for (int i = 0; i < universe.length; i++) {
            if (toBit(firstSet)[i] == 1 | toBit(secondSet)[i] == 1) res[i] = 1;
        }
        return res;
    }

    public int[] intersectionBit(int[] firstSet, int[] secondSet) {
        int[] res = new int[universe.length];
        for (int i = 0; i < universe.length; i++) {
            if (toBit(firstSet)[i] == 1 & toBit(secondSet)[i] == 1) res[i] = 1;
        }
        return res;
    }

    //Логічне доповнення
    public int[] complimentBit(int[] firstSet) {
        int[] res = new int[universe.length];
        int[] bitted = toBit(firstSet);
        for (int i = 0; i < bitted.length; i++) {
            if (bitted[i] != 1) res[i] = 1;
            else res[i] = 0;
        }
        return res;
    }

    // Бітова різниця
    public int[] differenceBit(int[] firstSet, int[] secondSet) {
        int[] res = new int[universe.length];
        for (int i = 0; i < universe.length; i++) {
            if (toBit(firstSet)[i] == 1 & toBit(secondSet)[i] == 0) res[i] = 1;
        }
        return res;
    }

    // Симетрична бітова різниця
    public int[] symmetricalDifferenceBit(int[] firstSet, int[] secondSet) {
        int[] res = new int[universe.length];
        for (int i = 0; i < universe.length; i++) {
            if (toBit(firstSet)[i] == 1 ^ toBit(secondSet)[i] == 1) res[i] = 1;
        }
        return res;
    }
}