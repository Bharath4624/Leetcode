class Solution {
    public boolean checkValidString(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int wildcardCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftCount++;
            } else if (ch == ')') {
                rightCount++;
            } else { 
                wildcardCount++;
            }
            if (rightCount > leftCount + wildcardCount) {
                return false;
            }
        }
        leftCount = 0;
        rightCount = 0;
        wildcardCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftCount++;
            } else if (ch == ')') {
                rightCount++;
            } else { 
                wildcardCount++;
            }
            if (leftCount > rightCount + wildcardCount) {
                return false;
            }
        }
        return true;
    }
}
