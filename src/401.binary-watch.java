import java.util.List;

/*
 * @lc app=leetcode id=401 lang=java
 *
 * [401] Binary Watch
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        boolean[] on = new boolean[10];
        List<String> list = new ArrayList<>();
        dfs(on, 0, num, 0, list);
        return list;
    }

    private void dfs(boolean[] on, int count, int num, int pos, List<String> list) {
        if (count == num) {
            String time = vec2String(on);
            if (time != null) {
                list.add(time);
            }
        } else {
            if (10 + count - num < pos) {
                return;
            } else {
                for (int i = pos; i < 10; ++i) {
                    on[i] = true;
                    dfs(on, count + 1, num, i + 1, list);
                    on[i] = false;
                }
            }
        }
    }

    private String vec2String(boolean[] on) {
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < 4; ++i) {
            if (on[i]) {
                hour |= (1 << i);
            }
        }
        for (int i = 4; i < 10; ++i) {
            if (on[i]) {
                minute |= (1 << (i - 4));
            }
        }
        if (hour < 12 && minute < 60) {
            return String.format("%d:%02d", hour, minute);
        } else {
            return null;
        }
    }
}
