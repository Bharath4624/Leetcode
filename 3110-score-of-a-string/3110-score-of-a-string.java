class Solution {
    public int scoreOfString(String s) {
        int k=0;
        for(int i=0;i<s.length()-1;i++){
            k+=(int)Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return k;
    }
}