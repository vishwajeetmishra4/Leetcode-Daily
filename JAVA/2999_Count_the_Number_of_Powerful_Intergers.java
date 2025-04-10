// Problem Number: 2999

// Count the Numbers of Powerful Integers.

class Solution {
    private String s;
    private String a, b;
    private int limit;
    private Long[][][] memo;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.s = s;
        this.a = String.valueOf(start);
        this.b = String.valueOf(finish);
        this.limit = limit;

        // Pad a and s with leading zeros to match the length of b
        a = "0".repeat(b.length() - a.length()) + a;
        s = "0".repeat(b.length() - s.length()) + s;

        memo = new Long[b.length()][2][2];

        return count(0, true, true);
    }

    private long count(int i, boolean tightA, boolean tightB) {
        if (i + s.length() == b.length()) {
            String aMinSuffix = tightA ? a.substring(b.length() - s.length()) : "0".repeat(s.length());
            String bMaxSuffix = tightB ? b.substring(b.length() - s.length()) : "9".repeat(s.length());

            long suffix = Long.parseLong(s);
            long aMin = Long.parseLong(aMinSuffix);
            long bMax = Long.parseLong(bMaxSuffix);

            return (aMin <= suffix && suffix <= bMax) ? 1 : 0;
        }

        int tA = tightA ? 1 : 0;
        int tB = tightB ? 1 : 0;
        if (memo[i][tA][tB] != null) {
            return memo[i][tA][tB];
        }

        long res = 0;
        int minDigit = tightA ? a.charAt(i) - '0' : 0;
        int maxDigit = tightB ? b.charAt(i) - '0' : 9;

        for (int d = minDigit; d <= maxDigit; ++d) {
            if (d > limit) continue;
            boolean nextTightA = tightA && (d == minDigit);
            boolean nextTightB = tightB && (d == maxDigit);
            res += count(i + 1, nextTightA, nextTightB);
        }

        memo[i][tA][tB] = res;
        return res;
    }
}
