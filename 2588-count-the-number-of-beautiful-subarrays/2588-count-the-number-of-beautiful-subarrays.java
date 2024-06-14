class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Long,Integer> map=new HashMap<>();
        long xor=0;
        long count=0;
        map.put(0L,1);
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(map.containsKey(xor)){
                count+=map.get(xor);
            }
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return count;
    }
}