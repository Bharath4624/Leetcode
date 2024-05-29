class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
       int i=0;
       int j=1;
       while(j<nums.length){
        if(nums[i]!=nums[j]){
            return nums[i];
        }
        i=j+1;
        j=i+1;
       } 
       return nums[i];
    }
}