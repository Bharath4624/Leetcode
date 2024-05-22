class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int k=0;
        while(x>0){
            k=k*10+x%10;
            x/=10;
        }
        return k==temp;
    }
}