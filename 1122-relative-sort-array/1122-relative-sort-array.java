class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr2){
            map.put(i,0);
        }
        int k=arr1.length-1;
        int[] ans=new int[arr1.length];
        for(int i:arr1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else{
                ans[k--]=i;
            }
        }
        int p=0;
        for(int i:arr2){
            int count=map.get(i);
            for(int j=0;j<count;j++){
                ans[p++]=i;
            }
        }
        Arrays.sort(ans,p,ans.length);
        return ans;
    }
}