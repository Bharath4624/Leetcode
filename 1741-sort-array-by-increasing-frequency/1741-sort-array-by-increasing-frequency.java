class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((a,b)->{
            if(a.getValue()-b.getValue()==0){
                return b.getKey()-a.getKey();
            }
            return a.getValue()-b.getValue();
        });
        int k=0;
        for(Map.Entry<Integer,Integer> i:list){
            for(int j=0;j<i.getValue();j++){
                nums[k++]=i.getKey();
            }
        }
        return nums;
    }
}