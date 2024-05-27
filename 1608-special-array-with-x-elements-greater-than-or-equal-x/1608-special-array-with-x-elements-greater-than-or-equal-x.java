class Solution {
    public int specialArray(int[] nums) {
        int count=0;
        for(int i=1;i<=nums.length;i++){
            count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]!=0 && nums[j]>=i){
                    count++;
                }
            }
            if(count==i){
                return count;
            }
        }
        return -1;
    }
}