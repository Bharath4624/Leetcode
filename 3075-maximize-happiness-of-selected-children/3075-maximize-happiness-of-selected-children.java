class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int ans[]=happiness;
        Arrays.sort(ans);
        int x=1;
        int last=ans.length-1;
        long count=ans[last];
        k--;
        last--;
        while(k>0){
            int a=ans[last];
            int rem=a-x;
            if(rem>0){
                count+=rem;
            }
            x++;
            last--;
            k--;
        }
        return count;
    }
}