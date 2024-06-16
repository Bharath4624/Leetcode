class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i:arr){
            high=Math.max(high,i);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(arr,mid)<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int func(int[] arr,int mid){
        int ans=0;
        for(int i:arr){
            ans+=Math.ceil((double)i/(double)mid);
        }
        return ans;
    }
}