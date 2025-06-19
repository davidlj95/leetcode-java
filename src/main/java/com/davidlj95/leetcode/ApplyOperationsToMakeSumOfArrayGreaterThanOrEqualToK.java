package com.davidlj95.leetcode;

/**
 * <h1>Plan</h1>
 * <p>
 * Maximum operations is in the worst scenario k-1, because
 * - [1] can be incremented until [k], hence k-1 increments
 * - [1] can be duplicated until [1, 1, 1, ...] K times produces k
 * <p>
 * How to find the minimum number of operations though?
 * <b>Not too many increments, too few duplications</b>
 * Like k-2 increments, then 1 duplication: [k-1, k-1]
 * - (k-1) - 1 (-1 as it's already there) = k-2 increment operations
 * - 1 duplication operation
 * Operations = k-2+1 = k-1 operations. Same as the worst case.
 * <b>Not too many duplications, too few increments</b>
 * Like 1 increment and rest are duplicates: [2, 2, 2... k/2 times]
 * - 1 increment operation
 * - (ceil(k/2) - 1) operations for duplication
 * ---⬆ ceil to default to excess (5/2 -> 3). -1 as 2 is already there after increment
 * Operations = ceil(k/2)-1+1=ceil(k/2). Better than the other approach. Still improvable.
 * <p>
 * How can the amount of duplication and increment operations be reduced to the sweet minimal spot?
 * An insight can be that duplication increases more the number per each operation.
 * Then the more, the better. However, not too many to avoid that one extra increase would have saved a duplication.
 * <p>
 * We can model the problem like this:
 * <p>
 * Given [x, x, x, x, ...], where x is repeated y times, must find the lowest
 * x and y such that x*y (x+x+x... y times) >= k
 * Then operations will be (x-1) (to get from 1 to x) and (y-1) to duplicate x y times.
 * Therefore, min_operations=(x-1)+(y-1)=x+y-2;
 * <p>
 * How to find those?
 * Calculating `y` is already done: ceil(k/x) (so we don't come short)
 * What about `x`? Can be found by:
 * - Brute force x in almost k compute complexity (see {@link #kComplexity}
 * - Compute x in constant time compute complexity (see {@link #constantComplexity})
 *
 * @see <a href="https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/>LeetCode problem (3091)</a>
 * @see <a href="https://www.youtube.com/watch?v=_5fM6Q_qZ4U">Explanation video</a>
 */
public class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK {
    @SuppressWarnings("unused")
    public static int minOperations(int k) {
        return constantComplexity(k);
    }

    /**
     * In here, we loop x until we find the operations count is minimum.
     */
    public static int kComplexity(int k) {
        double x = 0;
        int ops = k - 1, prevOps = k - 1;
        while (ops <= prevOps) {
            prevOps = ops;
            x++;
            var y = Math.ceil(k / x);
            ops = (int) (x + y - 2);
        }
        return prevOps;
    }

    /**
     * Another solution is to think about what is the optimal x value
     * If x*y=>k, then the best scenario is that x=y then x*x=k
     * As the closest the values, the lesser operations that will be spent to reach to them.
     * Hence, the optimal is x=sqrt(x). But ceil to default to excess.
     */
    public static int constantComplexity(int k) {
        var x = Math.ceil(Math.sqrt(k));
        var y = Math.ceil(k / x);
        return (int) (x + y - 2);
    }

    // Enabling think. Otherwise, it doesn't solve it.
    public static int constantChatGpt(int k) {
        var m = (int) Math.sqrt(k);
        if (m * m == k) return 2 * m - 2;
        if (k <= m * m + m) return 2 * m - 1;
        return 2 * m;
    }
}
