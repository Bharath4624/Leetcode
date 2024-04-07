class Solution {
    public int maxProfit(int[] prices) {
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        int min=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            int k=prices[i]-min;
            if(k<0){
                min=prices[i];
            }
            else if(k>maxprofit){
                maxprofit=k;
            }
            left[i]=maxprofit;
        }
        maxprofit=0;
        int min1=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            int a=min1-prices[i];
            if(a<0){
                min1=prices[i];
            }
            else if(a>maxprofit){
                maxprofit=a;
            }
            right[i]=maxprofit;
        }
        int ans=0;
        for(int i=0;i<prices.length;i++){
            ans=Math.max(ans,left[i]+right[i]);
        }
        return ans;
    }
}