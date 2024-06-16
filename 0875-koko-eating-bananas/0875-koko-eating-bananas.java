class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            int t=func(piles,mid);
            if(t<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int max(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public int func(int[] arr,int mid){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=Math.ceil((double)arr[i]/(double)mid);
        }
        return ans;
    }
}