class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            int j=i;
            while(j>=0 && nums[j]>nums[j+1]){
                int temp=nums[j];
                nums[j]=nums[j+1];
                nums[j+1]=temp;
                j--;
            }
        }
    }
}