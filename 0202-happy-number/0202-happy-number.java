import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        return isHappyHelper(n, set);
    }

    public boolean isHappyHelper(int n, HashSet<Integer> set) {
        int k = sum(n);
        if (k == 1) {
            return true;
        } else if (set.contains(k)) {
            return false;
        } else {
            set.add(k);
            return isHappyHelper(k, set);
        }
    }

    public int sum(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            ans += digit * digit;
            n /= 10;
        }
        return ans;
    }
}
