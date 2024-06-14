class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();
        long ans=1;
        list.add((int)ans);
        for(int i=1;i<rowIndex+1;i++){
            ans=ans*((rowIndex+1)-i);
            ans=ans/i;
            list.add((int)ans);
        }
        return list;
    }
}