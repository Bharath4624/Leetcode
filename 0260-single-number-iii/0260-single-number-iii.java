class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans=new int[2];
        int k=0;
        Arrays.sort(nums);
        int i=0;
        int j=1;
        while(j<nums.length){
            if(k==2){
                return ans;
            }
            if(nums[i]==nums[j]){
                i=j+1;
                j=i+1;
            }
            else{
                ans[k++]=nums[i];
                i=i+1;
                j=j+1;
            }
        }
        if(k!=2) ans[1]=nums[nums.length-1];
        return ans;
    }
}