class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
		int sum=0;
		int len=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			if(sum==k){
				len++;
			}
			if(map.containsKey(sum-k)){
				len+=map.get(sum-k);
			}
			map.put(sum,map.getOrDefault(sum,0)+1);
		}
		return len;
    }
}