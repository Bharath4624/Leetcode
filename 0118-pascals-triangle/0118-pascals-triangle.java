class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(func(i));
        }
        return ans;
    }
    public List<Integer> func(int n){
        int ans=1;
        List<Integer> list=new ArrayList<>();
        list.add(ans);
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            list.add(ans);
        }
        return list;
    }
}