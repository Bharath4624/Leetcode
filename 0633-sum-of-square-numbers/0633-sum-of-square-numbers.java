class Solution {
    public boolean judgeSquareSum(int c) {
        long low=0;
        long high=(long)Math.sqrt(c);
        while(low<=high){
            long mid=low*low + high*high;
            if((int)mid==c){
                return true;
            }
            else if(mid<c){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}