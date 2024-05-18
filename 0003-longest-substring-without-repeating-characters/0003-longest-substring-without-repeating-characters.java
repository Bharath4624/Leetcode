class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int res = 0;
        int i = 0;
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (lastIndex.containsKey(str.charAt(j))) {
                i = Math.max(i, lastIndex.get(str.charAt(j)) + 1);
            }
            res = Math.max(res, j - i + 1);
            lastIndex.put(str.charAt(j), j);
        }
        return res;
    }
}