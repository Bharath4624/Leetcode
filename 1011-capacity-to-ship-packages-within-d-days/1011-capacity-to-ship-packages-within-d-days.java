class Solution {
    public int shipWithinDays(int[] arr, int d) {
        int low=0;
        int high=0;
        for(int i:arr){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(arr,mid)<d){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static int func(int[] arr,int mid){
        int days=0;
        int load=0;
        for(int i:arr){
            if(i+load>mid){
                days++;
                load=i;
            }
            else{
                load+=i;
            }
        }
        return days;
    }
}