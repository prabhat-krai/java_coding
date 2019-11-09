package com.prabhat.exercise.top;
//Square root decomposition is a method or a data structure,
// which allows you to perform some typical operations
// (summation of subarray, range minimum/maximum query, etc.)
// in time complexity root of n, what is significantly better than O(n^2) when using trivial algorithm.

class MoAlgo
{

    static int MAXN = 10000;
    static int SQRSIZE = 100;

    static int []arr = new int[MAXN];
    static int []block = new int[SQRSIZE];
    static int blk_sz;


    static void update(int idx, int val)
    {
        int blockNumber = idx / blk_sz;
        block[blockNumber] += val - arr[idx];
        arr[idx] = val;
    }


    static int query(int l, int r)
    {
        int sum = 0;
        while (l < r && l % blk_sz != 0 && l != 0)
        {
            sum += arr[l];
            l++;
        }
        while (l+blk_sz <= r)
        {
            sum += block[l / blk_sz];
            l += blk_sz;
        }
        while (l <= r)
        {
            sum += arr[l];
            l++;
        }
        return sum;
    }

    static void preprocess(int input[], int n)
    {
        int blk_idx = -1;

        blk_sz = (int) Math.sqrt(n);

        for (int i = 0; i < n; i++)
        {
            arr[i] = input[i];
            if (i % blk_sz == 0)
            {
                blk_idx++;
            }
            block[blk_idx] += arr[i];
        }
    }

    public static void main(String[] args)
    {
        int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10, 56, 133, 566, 444, 12, 22, 1000, 333, 4444};
        int n = input.length;

        preprocess(input, n);

        System.out.println("query(3, 8) : " +
                query(3, 8));
        System.out.println("query(1, 6) : " +
                query(1, 6));
        update(8, 0);
        System.out.println("query(8, 8) : " +
                query(8, 14));
    }
}