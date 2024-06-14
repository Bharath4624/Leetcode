class Solution {
    public int threeSumClosest(int[] nums, int x) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>x){
                    k--;
                }
                else{
                    j++;
                }
                if(Math.abs(x-sum)<Math.abs(x-ans)){
                    ans=sum;
                }
            }
        }
        return ans;
    }
}