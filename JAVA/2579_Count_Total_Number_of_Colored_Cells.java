// Problem Number: 2579

// Count Total number of Colored Cells.

class Solution {
    public long coloredCells(int n) {
        return 1L * n * n + 1L * (n - 1) * (n - 1);
    }
}
