class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new LinkedList<>(map.entrySet());
        Collections.sort(list,(a,b)->(b.getValue()).compareTo(a.getValue()));
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }
}