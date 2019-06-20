/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.51%)
 * Total Accepted:    226K
 * Total Submissions: 789K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            count++;
            for (int j = 2; j * i <= n; j++) {
                isPrime[i * j] = false;
            }
        }
        return count;
    }
}
