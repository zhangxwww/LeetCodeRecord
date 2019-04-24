/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int len = words.length;
        if (len != pattern.length()) {
            return false;
        }
        String[] hash = new String[26];
        String[] used = new String[len];
        int usedCount = 0;
        for (int i = 0; i < len; i++) {
            int index = pattern.charAt(i) - 'a';
            if (hash[index] == null) {
                hash[index] = words[i];
                for (int j = 0; j < usedCount; j++) {
                    if (used[j].equals(words[i])) {
                        return false;
                    }
                }
                used[usedCount++] = words[i];
            } else {
                if (!hash[index].equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
