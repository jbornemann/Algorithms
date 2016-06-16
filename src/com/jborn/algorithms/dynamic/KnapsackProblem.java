package com.jborn.algorithms.dynamic;


public class KnapsackProblem {

    public static void oneZeroKnapsack() {
        //Weight of each item
        int[] w = {3, 5, 7, 10};
        //Value of each item
        int[] v = {5, 2, 6, 10};
        //number of items
        int n = 4;
        //Size of knapsack
        int S = 10;

        int result = oneZeroKnapsack(S, w, v, n);
    }

    private static int oneZeroKnapsack(int S, int[] w, int[] v, int n) {
        if(S == 0) return 0;

        //For each weight of knapsack (sub-problem), what is the maximum value we can get from taking an item?
        int[][] M = new int[S][n];

        //For a knapsack of weight 0, each item will yeild a value of 0
        for(int x = 0; x < n-1; x++) {
            M[0][x] = 0;
        }

        //For each weighted knapsack, stating at a knapsack of capacity one
        for(int i = 1; i <= S - 1; i++) {
            for(int j = 0; j <= n - 1; j++) {
                if(w[j] <= i) {
                    M[i][j] = Math.max(v[j] + M[i - w[j]][S - 1], M[(j > 0 ? j - 1 : 0)][i]);
                }
                else {
                    //If it doesn't fit in a knapsack of size i, then the best value we can get from item j is 0
                    M[i][j] = 0;
                }
            }
        }
        return M[S - 1][n - 1];
    }
}
