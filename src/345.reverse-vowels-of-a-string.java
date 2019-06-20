/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int i = 0;
        int j = str.length - 1;
        while (i < j && i < len && j < len) {
            if (isVowels(str[i]) && isVowels(str[j])) {
                char c = str[i];
                str[i] = str[j];
                str[j] = c;
                ++i;
                --j;
            } else if (isVowels(str[i])) {
                --j;
            } else if (isVowels(str[j])) {
                ++i;
            } else {
                ++i;
                --j;
            }
        }
        return String.valueOf(str);
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }
}
