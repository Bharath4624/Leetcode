class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int low=1;
        int high=arr[arr.length-1]-arr[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(arr,mid,m)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    public static boolean func(int[] arr,int mid,int m){
        int x=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=mid){
                x++;
                last=arr[i];
            }
        }
        return x>=m;
    }
}