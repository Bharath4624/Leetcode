class Solution {
    public int minDays(int[] arr, int m, int k) {
        if(arr.length<(long)m*(long)k){
            return -1;
        }
        int low=0;
        int high=0;
        for(int i:arr){
            low=Math.min(i,low);
            high=Math.max(i,high);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(arr,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean func(int[] arr,int mid,int m,int k){
        int count=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                count++;
            }
            else{
                ans+=(count/k);
                count=0;
            }
        }
        ans+=(count/k);
        return ans>=m;
    }
}