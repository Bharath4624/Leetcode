class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int[] aux = new int[n];
        int auxSize = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = 0;

            for (int j = auxSize - 1; j >= 0 && aux[j] <= heights[i]; j--) {
                ans[i]++;
                auxSize--;
            }

            if (auxSize > 0) {
                ans[i]++;
            }

            aux[auxSize++] = heights[i];
        }

        return ans;
    }
}