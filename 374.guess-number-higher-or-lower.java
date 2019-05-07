/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (int) (((long) low + (long) high) / 2);
            int res = guess(mid);
            switch (res) {
            case -1:
                high = mid - 1;
                break;
            case 1:
                low = mid + 1;
                break;
            case 0:
                return mid;
            default:
                break;
            }
        }
        return low;
    }
}
