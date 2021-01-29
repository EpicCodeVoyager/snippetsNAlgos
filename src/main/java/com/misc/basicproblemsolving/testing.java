package com.misc.basicproblemsolving;

import java.util.Arrays;

public class testing {

    static int count(int n)
    {

        int table[] = new int[n + 1], i;

        Arrays.fill(table, 0);

        table[0] = 1;

        for (i = 2; i <= n; i++)
            table[i] += table[i - 2];
        for (i = 4; i <= n; i++)
            table[i] += table[i - 4];
        for (i = 6; i <= n; i++)
            table[i] += table[i - 6];

        return table[n];
    }
    public static void main(String[] args) {
        System.out.println("hi");
    }
}
