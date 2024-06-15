class Solution {
    public boolean search(int[] arr, int key) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==key){
                return true;
            }
            if(arr[l]==arr[mid] && arr[mid]==arr[h]){
                l++;
                h--;
                continue;
            }
            if(arr[l]<=arr[mid]){
                if(arr[l]<=key && key<=arr[mid]){
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
               if(arr[mid]<=key && key<=arr[h]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                } 
            }
        }
        return false;
    }
}