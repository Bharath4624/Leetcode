class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans=0;
        int next=0;
        for(int i=0;i<nums.length;i++){
            next=Math.max(nums[i],next);
            ans+=next-nums[i];
            next++;
        }
        return ans;
    }
}