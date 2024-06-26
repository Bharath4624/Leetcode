class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(nums,0,nums.length-1);
        }
        else{
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                int t=nums[index];
                nums[index]=nums[i];
                nums[i]=t;
                break;
            }
        }
        reverse(nums,index+1,nums.length-1);
        }
    }
    public static void reverse(int[] arr,int start,int end){
        while(start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
}