class Solution {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        if(str.equalsIgnoreCase(sb.toString())){
            return true;
        }
        return false;
    }
}