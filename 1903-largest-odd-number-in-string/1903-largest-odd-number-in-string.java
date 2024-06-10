class Solution {
    public String largestOddNumber(String num) {
        int i=num.length()-1;
        String ans="";
        while(i>=0){
            if(Character.getNumericValue(num.charAt(i))%2!=0){
                ans=num.substring(0,i+1);
                break;
            }
            i--;
        }
        return ans;
    }
}