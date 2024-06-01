class Solution {
    public int bulbSwitch(int n) {
        if(n<=1){
            return n;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(i*i<=n){
                count++;
            }
            else{
                break;
            }
        }
        return count-1;
    }
}