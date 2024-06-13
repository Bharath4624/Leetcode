class Solution {
    public void sortColors(int[] arr) {
        int n=arr.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int t=arr[low];
                arr[low]=arr[mid];
                arr[mid]=t;
                mid++;
                low++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int t=arr[high];
                arr[high]=arr[mid];
                arr[mid]=t;
                high--;
            }
        }
    }
}